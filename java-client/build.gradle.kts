/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

import com.github.jk1.license.ProjectData
import com.github.jk1.license.render.ReportRenderer
import org.gradle.api.tasks.testing.Test
import java.io.FileWriter
import java.net.HttpURLConnection
import java.net.URI
import java.net.URLEncoder
import java.util.Base64

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        // A release, not a -SNAPSHOT: the release job executes this plugin, and a
        // snapshot's contents can change between runs.
        "classpath"(group = "org.opensearch.gradle", name = "build-tools", version = "3.9.0")
    }
}

plugins {
    java
    `java-library`
    `maven-publish`
    signing
    id("com.github.jk1.dependency-license-report") version "3.1.4"
    id("org.owasp.dependencycheck") version "13.0.0"

    id("opensearch-java.spotless-conventions")
}
apply(plugin = "opensearch.repositories")
apply(plugin = "org.owasp.dependencycheck")

val runtimeJavaVersion = (System.getProperty("runtime.java")?.toInt())?.let(JavaVersion::toVersion) ?: JavaVersion.current()
logger.quiet("=======================================")
logger.quiet("  Runtime JDK Version   : " + runtimeJavaVersion)
logger.quiet("  Gradle JDK Version    : " + JavaVersion.current())
logger.quiet("=======================================")

java {
    // Java 17, not the 8 inherited from upstream opensearch-java. The default JSON
    // mapper is backed by Jackson 3, whose class files are major version 61, so a
    // Java 8 target advertised a baseline the artifact could never honour: a JDK 8
    // or 11 consumer gets UnsupportedClassVersionError as soon as a mapper is
    // created. README already documents 17.
    targetCompatibility = JavaVersion.VERSION_17
    sourceCompatibility = JavaVersion.VERSION_17

    withJavadocJar()
    withSourcesJar()

    registerFeature("awsSdk2Support") {
        usingSourceSet(sourceSets.get("main"))
        // Without this the capability name is derived from the Gradle project name
        // ("java-client"), which is not what this module is published as. Consumers
        // have to spell the capability out in their build scripts, and it cannot be
        // changed after a release, so it has to match the artifact.
        capability("software.amazon.opensearch", "opensearch-java-aws-sdk2-support", project.version.toString())
    }
    
    toolchain {
      languageVersion = JavaLanguageVersion.of(runtimeJavaVersion.majorVersion)
      vendor = JvmVendorSpec.ADOPTIUM
    }
}

sourceSets.main {
    java.setSrcDirs(emptyList<String>())
    resources.setSrcDirs(emptyList<String>())
}

val awsRuntimeSourceSet = sourceSets.create("awsRuntime") {
    java {
        srcDir("src/main/java")
        exclude("software/amazon/opensearch/client/aos/**")
        exclude("software/amazon/opensearch/client/aoss/**")
    }
    resources {
        srcDir("src/main/resources")
    }
}

val aosSourceSet = sourceSets.create("aos") {
    java {
        srcDir("src/main/java")
        srcDir("src/generated/aos/java")
        include("software/amazon/opensearch/client/aos/**")
    }
    compileClasspath += awsRuntimeSourceSet.output
    runtimeClasspath += awsRuntimeSourceSet.output
}

val aossSourceSet = sourceSets.create("aoss") {
    java {
        srcDir("src/main/java")
        srcDir("src/generated/aoss/java")
        include("software/amazon/opensearch/client/aoss/**")
    }
    compileClasspath += awsRuntimeSourceSet.output
    runtimeClasspath += awsRuntimeSourceSet.output
}

configurations[awsRuntimeSourceSet.implementationConfigurationName].extendsFrom(configurations["implementation"])
configurations[awsRuntimeSourceSet.compileOnlyConfigurationName].extendsFrom(
    configurations["compileOnly"],
    configurations["awsSdk2SupportApi"]
)
configurations[aosSourceSet.implementationConfigurationName].extendsFrom(configurations["implementation"])
configurations[aosSourceSet.compileOnlyConfigurationName].extendsFrom(
    configurations["compileOnly"],
    configurations["awsSdk2SupportApi"]
)
configurations[aossSourceSet.implementationConfigurationName].extendsFrom(configurations["implementation"])
configurations[aossSourceSet.compileOnlyConfigurationName].extendsFrom(
    configurations["compileOnly"],
    configurations["awsSdk2SupportApi"]
)

sourceSets.test {
    java {
        setSrcDirs(listOf("src/test/java"))
        include("software/amazon/opensearch/client/**")
    }
    compileClasspath += awsRuntimeSourceSet.output + aosSourceSet.output + aossSourceSet.output
    runtimeClasspath += awsRuntimeSourceSet.output + aosSourceSet.output + aossSourceSet.output
}

tasks.named("compileAosJava") {
    dependsOn("compileAwsRuntimeJava")
}

tasks.named("compileAossJava") {
    dependsOn("compileAwsRuntimeJava")
}

tasks.named("compileTestJava") {
    dependsOn("compileAwsRuntimeJava", "compileAosJava", "compileAossJava")
}

tasks.named<Jar>("jar") {
    dependsOn("awsRuntimeClasses", "aosClasses", "aossClasses")
    exclude("org/opensearch/client/**")
    from(awsRuntimeSourceSet.output, aosSourceSet.output, aossSourceSet.output)
}

tasks.named<Jar>("sourcesJar") {
    exclude("org/opensearch/client/**")
    from(awsRuntimeSourceSet.allSource, aosSourceSet.allSource, aossSourceSet.allSource)
}

tasks.named<Javadoc>("javadoc") {
    dependsOn("compileAwsRuntimeJava")
    setSource(files(awsRuntimeSourceSet.allJava, aosSourceSet.allJava, aossSourceSet.allJava))
    classpath = files(
        awsRuntimeSourceSet.compileClasspath,
        aosSourceSet.compileClasspath,
        aossSourceSet.compileClasspath
    )
}

tasks.withType<ProcessResources> {
    expand(mapOf(
        "version" to version,
        "git_revision" to (if (rootProject.extra.has("gitHashFull")) rootProject.extra["gitHashFull"] else "unknown")
    ))
}

tasks.withType<Javadoc>().configureEach{
    options {
        this as StandardJavadocDocletOptions
        encoding = "UTF-8"
        addMultilineStringsOption("tag").setValue(listOf(
            "apiNote:a:API Note:",
            "implSpec:a:Implementation Requirements:",
            "implNote:a:Implementation Note:",
        ))
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
        attributes["Implementation-Title"] = "AWS OpenSearch Java Data Client"
        attributes["Implementation-Vendor"] = "Amazon Web Services"
        attributes["Implementation-URL"] = "https://github.com/aws/opensearch-java-aws/"
        attributes["Build-Date"] = rootProject.extra["buildTime"]
    }

    metaInf {
        from("../LICENSE.txt")
        from("../NOTICE.txt")
    }
}

tasks.build {
    dependsOn("spotlessJavaCheck")
}

tasks.test {
    systemProperty("tests.security.manager", "false")
    exclude("**/*RealResourceIT.class")
}

val unitTest = tasks.register<Test>("unitTest") {
    description = "Runs the AWS AOS/AOSS client unit tests."
    group = "verification"
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
    include("software/amazon/opensearch/client/**/*Test.class")
    include("software/amazon/opensearch/client/**/*Tests.class")
    exclude("**/*RealResourceIT.class")
    systemProperty("tests.security.manager", "false")
}

tasks.register<Test>("realResourceTest") {
    description = "Runs opt-in tests against configured AOS and AOSS resources."
    group = "verification"
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
    include("**/*RealResourceIT.class")
    systemProperty("tests.security.manager", "false")
}

dependencies {
    val awsSdkVersion = "2.56.0"
    val jacksonVersion = "2.22.2"
    val jacksonDatabindVersion = "2.22.2"
    val jackson3Version = "3.2.2"
    val jackson3DatabindVersion = "3.2.2"

    // Apache 2.0
    api("commons-logging:commons-logging:1.4.0")
    testImplementation("org.hamcrest:hamcrest:3.0")

    api("org.apache.httpcomponents.client5:httpclient5:5.6.5") {
      exclude(group = "org.apache.httpcomponents.core5")
    }
    api("org.apache.httpcomponents.core5:httpcore5:5.4.4")
    api("org.apache.httpcomponents.core5:httpcore5-h2:5.4.4")

    // Apache 2.0
    // https://search.maven.org/artifact/com.google.code.findbugs/jsr305
    api("com.google.code.findbugs:jsr305:3.0.2")

    // Needed even if using Jackson to have an implementation of the Jsonp object model
    // EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
    // https://github.com/eclipse-ee4j/parsson
    api("org.eclipse.parsson:parsson:1.1.9")

    // EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
    // http://json-b.net/
    implementation("jakarta.json.bind", "jakarta.json.bind-api", "2.0.0")

    // EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
    // https://projects.eclipse.org/projects/ee4j.ca
    implementation("jakarta.annotation", "jakarta.annotation-api", "1.3.5")

    // Apache 2.0
    implementation("tools.jackson.core", "jackson-core", jackson3Version)
    implementation("tools.jackson.core", "jackson-databind", jackson3DatabindVersion)
    compileOnly("com.fasterxml.jackson.core", "jackson-core", jacksonVersion)
    compileOnly("com.fasterxml.jackson.core", "jackson-databind", jacksonDatabindVersion)
    testImplementation("com.fasterxml.jackson.datatype", "jackson-datatype-jakarta-jsonp", jacksonVersion)

    // For AwsSdk2Transport.
    //
    // Pinned rather than a range. A range here was wrong in both directions: its
    // `2.21` floor was unusable, because `AwsSdk2Transport` calls
    // `ContentStreamProvider.fromByteArrayUnsafe`, which only exists from 2.25.69 on
    // -- SDK 2.25.0 satisfied the range and then failed at runtime with
    // NoSuchMethodError. And a range leaks into the published POM, where a Maven
    // consumer that does not import the AWS SDK BOM makes Maven fetch the POM of
    // every version in range; measured at 11k POM downloads over 70 minutes before
    // Maven Central started returning HTTP 429.
    //
    // A single version also makes the library's own build reproducible, which a
    // range does not: every build used whatever the newest SDK was that day.
    // Consumers can still move off this version by importing their own BOM or
    // declaring the artifacts directly.
    "awsSdk2SupportApi"("software.amazon.awssdk", "sdk-core", awsSdkVersion)
    "awsSdk2SupportApi"("software.amazon.awssdk", "auth", awsSdkVersion)
    "awsSdk2SupportApi"("software.amazon.awssdk", "http-auth-aws", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "sdk-core", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "auth", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "http-auth-aws", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "aws-crt-client", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "apache-client", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "apache5-client", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "netty-nio-client", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "url-connection-client", awsSdkVersion)
    testImplementation("software.amazon.awssdk", "sts", awsSdkVersion)

    testImplementation("org.apache.logging.log4j", "log4j-api","[2.17.1,3.0)") {
        exclude(group = "com.github.spotbugs", module = "spotbugs-annotations")
    }
    testImplementation("org.apache.logging.log4j", "log4j-core","[2.17.1,3.0)") {
        exclude(group = "com.github.spotbugs", module = "spotbugs-annotations")
    }

    // EPL-2.0 OR BSD-3-Clause
    // https://eclipse-ee4j.github.io/yasson/
    implementation("org.eclipse", "yasson", "2.0.2")

    // https://github.com/classgraph/classgraph
    testImplementation("io.github.classgraph:classgraph:4.8.196")

    // Eclipse 1.0
    testImplementation("junit", "junit" , "4.13.2") {
        exclude(group = "org.hamcrest")
    }
    
    // The Bouncy Castle License (MIT): https://www.bouncycastle.org/licence.html
    testImplementation("org.bouncycastle", "bcprov-lts8on", "2.73.6")
    testImplementation("org.bouncycastle", "bcpkix-lts8on", "2.73.6")
}

licenseReport {
    renderers = arrayOf(SpdxReporter(rootProject.layout.buildDirectory.file("release/dependencies.csv").get().getAsFile()))
}

class SpdxReporter(val dest: File) : ReportRenderer {
    // License names to their SPDX identifier
    val spdxIds = mapOf(
        "Apache License, Version 2.0" to "Apache-2.0",
        "The Apache Software License, Version 2.0" to "Apache-2.0",
        "BSD Zero Clause License" to "0BSD",
        "Eclipse Public License 2.0" to "EPL-2.0",
        "Eclipse Public License v. 2.0" to "EPL-2.0",
        "GNU General Public License, version 2 with the GNU Classpath Exception" to "GPL-2.0 WITH Classpath-exception-2.0",
        "COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Version 1.0" to "CDDL-1.0"
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
                val depUrl = info.moduleUrls.first()

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

publishing {
    repositories{
        // Releases are not pushed to a staging repository. The Central Publisher Portal
        // takes a single zipped bundle instead, which `centralBundle` builds from the
        // `localRepo` output below. See `publishToCentralPortal`.
        maven(rootProject.layout.buildDirectory.dir("repository")) {
            name = "localRepo"
        }
    }
    publications {
        create<MavenPublication>("publishMaven") {
            from(components["java"])
            pom {
                name.set("AWS OpenSearch Java Data Client")
                packaging = "jar"
                artifactId = "opensearch-java"
                description.set("Typed Java data-plane clients for Amazon OpenSearch Service and OpenSearch Serverless.")
                url.set("https://github.com/aws/opensearch-java-aws/")
                inceptionYear.set("2026")
                scm {
                    connection.set("scm:git:https://github.com/aws/opensearch-java-aws.git")
                    developerConnection.set("scm:git:ssh://git@github.com/aws/opensearch-java-aws.git")
                    url.set("https://github.com/aws/opensearch-java-aws")
                }
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        name.set("Amazon Web Services")
                        url.set("https://aws.amazon.com/opensearch-service/")
                    }
                }
            }
        }
    }
}


// ---------------------------------------------------------------------------------------------
// Central Publisher Portal release publishing.
//
// The Portal does not accept artifact-by-artifact uploads to a staging repository the way the
// retired OSSRH Nexus did. Instead a release is one archive whose contents follow the Maven
// repository layout, uploaded in a single request. `localRepo` already produces exactly that
// layout under build/repository, so `centralBundle` only has to zip it and `publishToCentralPortal`
// only has to POST it.
//
// See https://central.sonatype.org/publish/publish-portal-api/
// ---------------------------------------------------------------------------------------------

private val centralPortalUploadUrl = "https://central.sonatype.com/api/v1/publisher/upload"
private val centralPortalStatusUrl = "https://central.sonatype.com/api/v1/publisher/status"

// Stale artifacts from an earlier build would otherwise be swept into the bundle and rejected,
// or worse, published alongside the current version.
val cleanLocalRepo by tasks.registering(Delete::class) {
    delete(rootProject.layout.buildDirectory.dir("repository"))
}

tasks.named("publishPublishMavenPublicationToLocalRepoRepository") {
    mustRunAfter(cleanLocalRepo)
}

val centralBundle by tasks.registering(Zip::class) {
    group = "publishing"
    description = "Builds the Central Publisher Portal deployment bundle from the local repository layout."

    dependsOn(cleanLocalRepo, "publishPublishMavenPublicationToLocalRepoRepository")

    from(rootProject.layout.buildDirectory.dir("repository")) {
        // The Portal derives coordinates from the directory layout and rejects repository-level
        // metadata, which Gradle writes for its own benefit.
        exclude("**/maven-metadata.xml", "**/maven-metadata.xml.*")
    }
    archiveFileName.set("central-bundle.zip")
    destinationDirectory.set(layout.buildDirectory)

    doFirst {
        if (version.toString().endsWith("SNAPSHOT")) {
            throw GradleException(
                "Refusing to build a Central Portal bundle for snapshot version '$version'. " +
                    "The Portal only accepts release versions; set the VERSION environment variable, " +
                    "e.g. VERSION=x.y.z ./gradlew :java-client:centralBundle. " +
                    "(-Dversion only sets the base version and still yields a snapshot.)"
            )
        }

        // The signing plugin is a no-op when no key is configured, which would otherwise
        // produce a well-formed but unsigned bundle. The Portal only rejects that after
        // upload, so fail here instead.
        val repoDir = rootProject.layout.buildDirectory.dir("repository").get().asFile
        val signable = repoDir.walkTopDown()
            .filter { it.isFile }
            .filterNot { it.name.startsWith("maven-metadata.xml") }
            .filterNot { it.name.endsWith(".asc") }
            .filterNot { it.name.endsWith(".md5") || it.name.endsWith(".sha1") }
            .filterNot { it.name.endsWith(".sha256") || it.name.endsWith(".sha512") }
            .toList()

        if (signable.isEmpty()) {
            throw GradleException("No publishable artifacts found under $repoDir.")
        }
        val unsigned = signable.filterNot { File("${it.path}.asc").isFile }
        if (unsigned.isNotEmpty()) {
            throw GradleException(
                "Maven Central requires a PGP signature for every published file, but " +
                    unsigned.size + " of " + signable.size + " have no .asc:\n" +
                    unsigned.joinToString("\n") { "  " + it.relativeTo(repoDir).path } +
                    "\nSupply the signing key via the signingKey and signingPassword Gradle " +
                    "properties (or ORG_GRADLE_PROJECT_signingKey / ORG_GRADLE_PROJECT_signingPassword)."
            )
        }
    }
}

val publishToCentralPortal by tasks.registering {
    group = "publishing"
    description = "Uploads the deployment bundle to the Central Publisher Portal."

    dependsOn(centralBundle)

    // Resolved at configuration time so the task body stays free of Project access.
    val bundleFile = centralBundle.flatMap { it.archiveFile }
    val deploymentName = "${project.group}:opensearch-java:$version"
    val username = (findProperty("centralPortalUsername") as String?) ?: System.getenv("CENTRAL_PORTAL_USERNAME")
    val token = (findProperty("centralPortalToken") as String?) ?: System.getenv("CENTRAL_PORTAL_TOKEN")
    // USER_MANAGED holds the deployment in the Portal for a human to release. AUTOMATIC publishes
    // straight to Maven Central on successful validation and cannot be undone.
    val publishingType = (findProperty("centralPublishingType") as String?) ?: "USER_MANAGED"

    doLast {
        if (username.isNullOrBlank() || token.isNullOrBlank()) {
            throw GradleException(
                "Central Portal credentials are missing. Set the centralPortalUsername and " +
                    "centralPortalToken Gradle properties, or the CENTRAL_PORTAL_USERNAME and " +
                    "CENTRAL_PORTAL_TOKEN environment variables, to a Portal user token."
            )
        }
        if (publishingType != "USER_MANAGED" && publishingType != "AUTOMATIC") {
            throw GradleException("centralPublishingType must be USER_MANAGED or AUTOMATIC, was '$publishingType'.")
        }

        val bundle = bundleFile.get().asFile
        val credential = Base64.getEncoder().encodeToString("$username:$token".toByteArray())
        val deploymentId = uploadCentralBundle(bundle, credential, deploymentName, publishingType)

        logger.lifecycle("Uploaded ${bundle.name} to the Central Publisher Portal as deployment $deploymentId.")
        if (publishingType == "USER_MANAGED") {
            logger.lifecycle("Validation is running. Release it from https://central.sonatype.com/publishing/deployments once it reports VALIDATED.")
        }
    }
}

/**
 * Posts [bundle] to the Portal upload endpoint as a `multipart/form-data` part named `bundle`,
 * returning the deployment ID. The body is assembled by hand to keep the build free of an HTTP
 * client dependency.
 */
fun uploadCentralBundle(bundle: File, credential: String, deploymentName: String, publishingType: String): String {
    val boundary = "----CentralBundle${System.currentTimeMillis()}"
    val query = "?name=${URLEncoder.encode(deploymentName, "UTF-8")}&publishingType=$publishingType"
    val connection = URI("$centralPortalUploadUrl$query").toURL().openConnection() as HttpURLConnection

    connection.requestMethod = "POST"
    connection.doOutput = true
    connection.setRequestProperty("Authorization", "Bearer $credential")
    connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=$boundary")
    connection.connectTimeout = 30_000
    // Validation happens before the response is written, so the read timeout has to be generous.
    connection.readTimeout = 600_000
    // Avoid buffering the whole bundle in heap on the way out.
    connection.setChunkedStreamingMode(0)

    connection.outputStream.use { out ->
        out.write(
            (
                "--$boundary\r\n" +
                    "Content-Disposition: form-data; name=\"bundle\"; filename=\"${bundle.name}\"\r\n" +
                    "Content-Type: application/octet-stream\r\n\r\n"
                ).toByteArray()
        )
        bundle.inputStream().use { it.copyTo(out) }
        out.write("\r\n--$boundary--\r\n".toByteArray())
    }

    val status = connection.responseCode
    val body = (if (status in 200..299) connection.inputStream else connection.errorStream)
        ?.bufferedReader()?.use { it.readText() }?.trim()
        ?: ""

    if (status !in 200..299) {
        throw GradleException("Central Portal upload failed with HTTP $status: $body")
    }
    if (body.isEmpty()) {
        throw GradleException("Central Portal upload returned HTTP $status with no deployment ID.")
    }
    return body
}

val checkCentralPortalStatus by tasks.registering {
    group = "publishing"
    description = "Reports the Portal status of a deployment. Pass -PdeploymentId=<id>."

    val deploymentId = findProperty("deploymentId") as String?
    val username = (findProperty("centralPortalUsername") as String?) ?: System.getenv("CENTRAL_PORTAL_USERNAME")
    val token = (findProperty("centralPortalToken") as String?) ?: System.getenv("CENTRAL_PORTAL_TOKEN")

    doLast {
        if (deploymentId.isNullOrBlank()) {
            throw GradleException("Pass the deployment to inspect with -PdeploymentId=<id>.")
        }
        if (username.isNullOrBlank() || token.isNullOrBlank()) {
            throw GradleException("Central Portal credentials are missing. See publishToCentralPortal for the accepted properties.")
        }

        val credential = Base64.getEncoder().encodeToString("$username:$token".toByteArray())
        val connection = URI("$centralPortalStatusUrl?id=$deploymentId").toURL().openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.setRequestProperty("Authorization", "Bearer $credential")
        connection.connectTimeout = 30_000
        connection.readTimeout = 60_000

        val status = connection.responseCode
        val body = (if (status in 200..299) connection.inputStream else connection.errorStream)
            ?.bufferedReader()?.use { it.readText() }?.trim()
            ?: ""

        if (status !in 200..299) {
            throw GradleException("Central Portal status check failed with HTTP $status: $body")
        }
        logger.lifecycle(body)
    }
}

tasks.withType<Test>().configureEach {
    dependsOn("awsRuntimeClasses", "aosClasses", "aossClasses")
    classpath += awsRuntimeSourceSet.output + aosSourceSet.output + aossSourceSet.output
}

signing {
    val signingKey = findProperty("signingKey") as String?
    val signingPassword = findProperty("signingPassword") as String?
    val hasKeyring = findProperty("signing.keyId") != null
    isRequired = signingKey != null || hasKeyring
    if (signingKey != null) {
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
    if (isRequired) {
        sign(publishing.publications["publishMaven"])
    }
}
