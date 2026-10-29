/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

import com.github.jk1.license.ProjectData
import com.github.jk1.license.render.ReportRenderer
import de.undercouch.gradle.tasks.download.Download
import java.io.FileWriter
import java.security.MessageDigest

plugins {
    application
    id("com.github.jk1.dependency-license-report") version "3.1.4"
    id("org.owasp.dependencycheck") version "13.0.0"
    id("de.undercouch.download") version "5.7.0"

    id("opensearch-java.spotless-conventions")
}
apply(plugin = "org.owasp.dependencycheck")

val runtimeJavaVersion = (System.getProperty("runtime.java")?.toInt())?.let(JavaVersion::toVersion) ?: JavaVersion.current()
logger.quiet("=======================================")
logger.quiet("  Runtime JDK Version   : $runtimeJavaVersion")
logger.quiet("  Gradle JDK Version    : " + JavaVersion.current())
logger.quiet("=======================================")

java {
    targetCompatibility = JavaVersion.VERSION_17
    sourceCompatibility = JavaVersion.VERSION_17

    withJavadocJar()
    withSourcesJar()

    toolchain {
        languageVersion = JavaLanguageVersion.of(runtimeJavaVersion.majorVersion)
        vendor = JvmVendorSpec.ADOPTIUM
    }
}

application {
    mainClass.set("software.amazon.opensearch.client.codegen.CodeGenerator")
    applicationDefaultJvmArgs = listOf(
        "--add-exports", "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
        "--add-exports", "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
    )
}

val distributionSpecsDir = providers.gradleProperty("distributionSpecsDir")
    .orElse(projectDir.absolutePath)

fun registerDistributionClientTask(
    taskName: String,
    distribution: String,
    specificationFileName: String,
    modelPackage: String,
    clientName: String
) {
    tasks.register<JavaExec>(taskName) {
        group = "code generation"
        description = "Generates the $distribution Java client into the java-codegen build directory."
        dependsOn("classes")
        dependsOn("verifySpecChecksums")

        mainClass.set(application.mainClass)
        classpath = sourceSets["main"].runtimeClasspath

        val specificationFile = file("${distributionSpecsDir.get()}/$specificationFileName")
        val outputDirectory = project(":java-client").layout.projectDirectory.dir("src/generated/$distribution/java")

        inputs.file(specificationFile)
        outputs.dir(outputDirectory)

        doFirst {
            check(specificationFile.isFile) {
                "Distribution specification not found: $specificationFile. " +
                    "Restore the bundled snapshot or pass -PdistributionSpecsDir=<directory>."
            }
        }

        args = listOf(
            "--input", specificationFile.toURI().toString(),
            "--eclipse-config", "$rootDir/buildSrc/formatterConfig-generated.xml",
            "--output", outputDirectory.asFile.absolutePath,
            "--distribution", distribution,
            "--runtime-package", "software.amazon.opensearch.client",
            "--model-package", modelPackage,
            "--client-name", clientName
        )
    }
}

registerDistributionClientTask(
    "generateAosClient",
    "aos",
    "opensearch-openapi-aos.yaml",
    "software.amazon.opensearch.client.aos",
    "OpenSearchAos"
)

registerDistributionClientTask(
    "generateAossClient",
    "aoss",
    "opensearch-openapi-aoss.yaml",
    "software.amazon.opensearch.client.aoss",
    "OpenSearchAoss"
)

tasks.register("generateClients") {
    group = "code generation"
    description = "Generates both AOS and AOSS Java clients."
    dependsOn("generateAosClient", "generateAossClient")
}

// Each generator-input spec is pinned by a committed `<spec>.sha256` holding the
// bare SHA-256 of the spec bytes, mirroring OpenSearch core's `<jar>.sha1`
// dependency pins. `updateSpecShas` writes a missing pin (never silently
// overwrites an existing one); `verifySpecChecksums` (a dependency of every
// client-generation task) recomputes each spec's hash and fails the build on a
// mismatch or a missing pin, so a spec changes only through a reviewed refresh.
val distributionSpecFiles = listOf(
    "opensearch-openapi-aos.yaml",
    "opensearch-openapi-aoss.yaml"
)

fun sha256Of(f: File): String {
    val digest = MessageDigest.getInstance("SHA-256").digest(f.readBytes())
    val sb = StringBuilder(digest.size * 2)
    for (b in digest) {
        sb.append("%02x".format(b))
    }
    return sb.toString()
}

fun shaFileFor(specName: String): File = file("${projectDir}/$specName.sha256")

// Refreshes the committed AOS/AOSS distribution specs from the published
// OpenSearch API spec site. These downloaded files are the generator input; run
// this task (it refreshes the `<spec>.sha256` pins too), then commit the updated
// specs and pins via PR so the spec change is reviewed before code is
// regenerated from it.
tasks.register<Download>("downloadLatestSpecs") {
    group = "code generation"
    description = "Downloads the latest AOS and AOSS distribution specs into java-codegen and refreshes their checksum pins."
    src(
        listOf(
            "https://api-spec.opensearch.org/opensearch-openapi-aos.yaml",
            "https://api-spec.opensearch.org/opensearch-openapi-aoss.yaml"
        )
    )
    dest(projectDir)
    overwrite(true)
    doLast {
        // A fresh download may change the spec, so re-pin unconditionally here.
        distributionSpecFiles.forEach { name ->
            val sha = sha256Of(file("${projectDir}/$name"))
            shaFileFor(name).writeText(sha + "\n")
            logger.quiet("Pinned $name.sha256")
        }
    }
}

// Writes a `<spec>.sha256` pin for any spec that does not have one yet, like
// OpenSearch's `updateShas`. Existing pins are left untouched so a change is
// never silently absorbed; refresh those with `downloadLatestSpecs`.
tasks.register("updateSpecShas") {
    group = "code generation"
    description = "Writes a SHA-256 pin for any distribution spec that is missing one."
    doLast {
        distributionSpecFiles.forEach { name ->
            val specFile = file("${projectDir}/$name")
            check(specFile.isFile) { "Distribution specification not found: $specFile" }
            val shaFile = shaFileFor(name)
            if (shaFile.exists()) {
                logger.quiet("Pin already present for $name")
            } else {
                shaFile.writeText(sha256Of(specFile) + "\n")
                logger.quiet("Added pin $name.sha256")
            }
        }
    }
}

// Verifies each generator-input spec on disk matches its committed `<spec>.sha256`
// pin. Every client-generation task depends on this so a spec that was changed
// without updating its pin never reaches the generator.
val verifySpecChecksums = tasks.register("verifySpecChecksums") {
    group = "verification"
    description = "Verifies the AOS and AOSS distribution specs match their committed SHA-256 pins."
    inputs.files(distributionSpecFiles.map { file("${projectDir}/$it") })
    inputs.files(distributionSpecFiles.map { shaFileFor(it) })
    doLast {
        distributionSpecFiles.forEach { name ->
            val specFile = file("${projectDir}/$name")
            check(specFile.isFile) { "Distribution specification not found: $specFile" }
            val shaFile = shaFileFor(name)
            check(shaFile.isFile) {
                "Checksum pin not found: ${shaFile.name}. Run `updateSpecShas` (or `downloadLatestSpecs`) to create it."
            }
            val want = shaFile.readText().trim()
            val got = sha256Of(specFile)
            check(got == want) {
                "Checksum mismatch for $name: expected $want but found $got. " +
                    "The spec was changed without updating ${shaFile.name}; refresh it via `downloadLatestSpecs` in a reviewed PR."
            }
        }
        logger.quiet("Verified ${distributionSpecFiles.size} distribution spec checksum pins.")
    }
}

tasks.withType<ProcessResources> {
    expand(mapOf(
        "version" to version,
        "git_revision" to (if (rootProject.extra.has("gitHashFull")) rootProject.extra["gitHashFull"] else "unknown")
    ))
}

tasks.withType<Javadoc>().configureEach{
    options {
        encoding = "UTF-8"
    }
}

tasks.withType<Jar> {
    doFirst {
        if (rootProject.extra.has("gitHashFull")) {
            val jar = this as Jar
            jar.manifest.attributes["X-Git-Revision"] = rootProject.extra["gitHashFull"]
            jar.manifest.attributes["X-Git-Commit-Time"] = rootProject .extra["gitCommitTime"]
        } else {
            throw GradleException("No git information available")
        }
    }

    manifest {
        attributes["Implementation-Title"] = "OpenSearch Java client code generator"
        attributes["Implementation-Vendor"] = "OpenSearch"
        attributes["Implementation-URL"] = "https://github.com/aws/opensearch-java-aws/"
        attributes["Build-Date"] = rootProject.extra["buildTime"]
    }

    metaInf {
        from("../LICENSE.txt")
        from("../NOTICE.txt")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.build {
    dependsOn("spotlessJavaCheck")
}

dependencies {
    // Apache 2.0
    implementation("io.swagger.parser.v3", "swagger-parser", "2.1.22")

    // Apache 2.0
    implementation("org.snakeyaml", "snakeyaml-engine", "3.2")

    // (New) BSD
    implementation("com.samskivert", "jmustache", "1.16")

    // Apache 2.0
    implementation("commons-cli", "commons-cli", "1.8.0")
    implementation("commons-codec", "commons-codec", "1.17.0")
    implementation("commons-logging", "commons-logging", "1.3.2")
    implementation("org.apache.commons", "commons-lang3", "3.14.0")
    implementation("org.apache.commons", "commons-text", "1.12.0")
    implementation("org.apache.logging.log4j", "log4j-api", "2.26.1")
    implementation("org.apache.logging.log4j", "log4j-core", "2.26.1")
    implementation("org.apache.logging.log4j", "log4j-slf4j2-impl", "2.26.1")

    // Apache 2.0
    implementation("com.fasterxml.jackson.core", "jackson-core", "2.22.2")
    implementation("com.fasterxml.jackson.core", "jackson-databind", "2.22.2")

    // Apache 2.0
    implementation("com.diffplug.spotless", "spotless-lib", "4.10.4")
    implementation("com.diffplug.spotless", "spotless-lib-extra", "4.10.4")

    // Apache 2.0
    // https://search.maven.org/artifact/com.google.code.findbugs/jsr305
    implementation("com.google.code.findbugs", "jsr305", "3.0.2")

    // Apache 2.0
    compileOnly("org.jetbrains", "annotations", "24.1.0")

    // Apache 2.0
    implementation("org.apache.maven.resolver", "maven-resolver-api", "1.9.20")
    implementation("org.apache.maven.resolver", "maven-resolver-supplier", "1.9.20")

    // MIT
    implementation("org.semver4j", "semver4j", "5.3.0")

    // BSD-2-Clause
    implementation("org.commonmark", "commonmark", "0.24.0")

    // EPL-2.0
    testImplementation(platform("org.junit:junit-bom:5.14.4"))
    testImplementation("org.junit.jupiter", "junit-jupiter")
    testRuntimeOnly("org.junit.platform", "junit-platform-launcher")
}

licenseReport {
    renderers = arrayOf(SpdxReporter(rootProject.layout.buildDirectory.file("release/codegen-dependencies.csv").get().getAsFile()))
    excludeGroups = arrayOf()
}

class SpdxReporter(val dest: File) : ReportRenderer {
    // License names to their SPDX identifier
    val spdxIds = mapOf(
        "Apache 2" to "Apache-2.0",
        "Apache 2.0" to "Apache-2.0",
        "Apache-2.0" to "Apache-2.0",
        "\"Apache-2.0\";link=\"https://www.apache.org/licenses/LICENSE-2.0.txt\"" to "Apache-2.0",
        "\"Apache 2.0\";link=\"http://www.apache.org/licenses/LICENSE-2.0.txt\"" to "Apache-2.0",
        "\"Apache License 2.0\";link=\"http://www.apache.org/licenses/LICENSE-2.0.html\"" to "Apache-2.0",
        "Apache License 2.0" to "Apache-2.0",
        "Apache License, version 2.0" to "Apache-2.0",
        "Apache License, Version 2.0" to "Apache-2.0",
        "Apache Software License, version 2.0" to "Apache-2.0",
        "The Apache License, Version 2.0" to "Apache-2.0",
        "The Apache Software License, Version 2.0" to "Apache-2.0",
        "BSD Zero Clause License" to "0BSD",
        "The (New) BSD License" to "BSD-3-Clause",
        "EDL 1.0" to "BSD-3-Clause",
        "Eclipse Distribution License - v 1.0" to "BSD-3-Clause",
        "Eclipse Distribution License (New BSD License)" to "BSD-3-Clause",
        "Eclipse Public License 2.0" to "EPL-2.0",
        "Eclipse Public License v. 2.0" to "EPL-2.0",
        "Eclipse Public License - v 2.0" to "EPL-2.0",
        "GNU General Public License, version 2 with the GNU Classpath Exception" to "GPL-2.0 WITH Classpath-exception-2.0",
        "COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Version 1.0" to "CDDL-1.0",
        "Lesser General Public License, version 3 or greater" to "LGPL-3.0+",
        "MIT" to "MIT",
        "MIT License" to "MIT",
        "The MIT License" to "MIT",
        "Mozilla Public License, Version 2.0" to "MPL-2.0",
        "Public Domain" to "PUBLIC-DOMAIN"
    )

    private fun quote(str: String) : String {
        return if (str.contains(',') || str.contains("\"")) {
            "\"" + str.replace("\"", "\"\"") + "\""
        } else {
            str
        }
    }

    override fun render(data: ProjectData?) {
        dest.parentFile.mkdirs()
        FileWriter(dest).use { out ->
            out.append("name,url,version,revision,license\n")
            data?.allDependencies?.forEach { dep ->
                val info = com.github.jk1.license.render.LicenseDataCollector.multiModuleLicenseInfo(dep)

                val depVersion = dep.version
                val depName = dep.group + ":" + dep.name
                val depUrl = if (info.moduleUrls.isNotEmpty()) { info.moduleUrls.first() } else { "<NO MODULE URL>" }

                val licenseIds = info.licenses.mapNotNull { license ->
                    license.name?.let {
                        checkNotNull(spdxIds[it]) { "No SPDX identifier for $license" }
                    }
                }.toSet()

                // Combine multiple licenses.
                // See https://spdx.github.io/spdx-spec/appendix-IV-SPDX-license-expressions/#composite-license-expressions
                val licenseId = licenseIds.joinToString(" OR ")
                out.append("${quote(depName)},${quote(depUrl)},${quote(depVersion)},,${quote(licenseId)}\n")
            }
        }
    }
}

tasks.withType<Jar> {
    doLast {
        ant.withGroovyBuilder {
            "checksum"("algorithm" to "md5", "file" to archiveFile.get())
            "checksum"("algorithm" to "sha1", "file" to archiveFile.get())
            "checksum"("algorithm" to "sha-256", "file" to archiveFile.get(), "fileext" to ".sha256")
            "checksum"("algorithm" to "sha-512", "file" to archiveFile.get(), "fileext" to ".sha512")
        }
    }
}

spotlessConventions {
    eclipseFormatterConfigFile = rootProject.file("buildSrc/formatterConfig-generated.xml")
}
