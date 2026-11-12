/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
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
import org.gradle.api.attributes.java.TargetJvmVersion
import org.gradle.api.tasks.testing.Test
import java.io.FileWriter

plugins {
    java
    `java-library`
    `maven-publish`
    id("com.vanniktech.maven.publish") version "0.37.0"
    id("com.github.jk1.dependency-license-report") version "3.1.5"
    id("org.owasp.dependencycheck") version "13.0.0"

    id("opensearch-java.spotless-conventions")
}

val runtimeJavaVersion = (System.getProperty("runtime.java")?.toInt())?.let(JavaVersion::toVersion) ?: JavaVersion.current()
logger.quiet("=======================================")
logger.quiet("  Runtime JDK Version   : " + runtimeJavaVersion)
logger.quiet("  Gradle JDK Version    : " + JavaVersion.current())
logger.quiet("=======================================")

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8

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

tasks.withType<JavaCompile>().configureEach {
    // Also reject JDK APIs introduced after Java 8 when compiling on a newer JDK.
    options.release.set(8)
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

val jackson3SourceSet = sourceSets.create("jackson3") {
    java.setSrcDirs(listOf("src/main/java21"))
    compileClasspath += awsRuntimeSourceSet.output
}
configurations[jackson3SourceSet.implementationConfigurationName].extendsFrom(configurations["implementation"])

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

val jackson3TestSourceSet = sourceSets.create("jackson3Test") {
    java.setSrcDirs(listOf("src/test/java21"))
    // Compile and run against the multi-release JAR, including its Java 21 entries.
    compileClasspath += files(tasks.jar.flatMap { it.archiveFile }) + sourceSets.test.get().output
    runtimeClasspath += files(tasks.jar.flatMap { it.archiveFile }) + sourceSets.test.get().output
}
configurations[jackson3TestSourceSet.implementationConfigurationName].extendsFrom(
    configurations["testImplementation"],
    configurations[jackson3SourceSet.compileOnlyConfigurationName]
)
configurations[jackson3TestSourceSet.runtimeOnlyConfigurationName].extendsFrom(configurations["testRuntimeOnly"])

listOf(jackson3SourceSet, jackson3TestSourceSet).forEach { sourceSet ->
    tasks.named<JavaCompile>(sourceSet.compileJavaTaskName) {
        options.release.set(21)
    }
    listOf(sourceSet.compileClasspathConfigurationName, sourceSet.runtimeClasspathConfigurationName).forEach { name ->
        configurations[name].attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 21)
    }
}
tasks.named(jackson3SourceSet.compileJavaTaskName) {
    dependsOn("compileAwsRuntimeJava")
}
tasks.named(jackson3TestSourceSet.compileJavaTaskName) {
    dependsOn(tasks.jar, tasks.testClasses)
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
    dependsOn("awsRuntimeClasses", "aosClasses", "aossClasses", jackson3SourceSet.classesTaskName)
    exclude("org/opensearch/client/**")
    from(awsRuntimeSourceSet.output, aosSourceSet.output, aossSourceSet.output)
    into("META-INF/versions/21") {
        from(jackson3SourceSet.output)
    }
    manifest.attributes["Multi-Release"] = "true"
}

tasks.withType<Jar>().matching { it.name == "sourcesJar" }.configureEach {
    exclude("org/opensearch/client/**")
    from(awsRuntimeSourceSet.allSource, aosSourceSet.allSource, aossSourceSet.allSource)
    into("META-INF/versions/21") {
        from(jackson3SourceSet.allSource)
    }
}

tasks.named<Javadoc>("javadoc") {
    dependsOn("compileAwsRuntimeJava")
    setSource(files(awsRuntimeSourceSet.allJava, aosSourceSet.allJava, aossSourceSet.allJava, jackson3SourceSet.allJava))
    classpath = files(
        awsRuntimeSourceSet.compileClasspath,
        aosSourceSet.compileClasspath,
        aossSourceSet.compileClasspath,
        jackson3SourceSet.compileClasspath
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
    dependsOn("jackson3Test")
    systemProperty("tests.security.manager", "false")
    exclude("**/*RealResourceIT.class")
}

val unitTest = tasks.register<Test>("unitTest") {
    description = "Runs the AWS AOS/AOSS client unit tests."
    group = "verification"
    dependsOn("jackson3Test")
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
    include("software/amazon/opensearch/client/**/*Test.class")
    include("software/amazon/opensearch/client/**/*Tests.class")
    exclude("**/*RealResourceIT.class")
    systemProperty("tests.security.manager", "false")
}

tasks.register<Test>("jackson3Test") {
    description = "Runs Jackson 3 transport tests against the multi-release JAR on the build JDK (21+)."
    group = "verification"
    testClassesDirs = jackson3TestSourceSet.output.classesDirs
    classpath = jackson3TestSourceSet.runtimeClasspath
    include("**/*Tests.class")
    systemProperty("tests.security.manager", "false")
}

tasks.register<Test>("java8Test") {
    description = "Runs the AWS AOS/AOSS client unit tests against the packaged JAR on Java 8."
    group = "verification"
    dependsOn(tasks.jar, tasks.testClasses)
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(8))
    })
    testClassesDirs = sourceSets.test.get().output.classesDirs
    // Load client classes from the artifact consumers receive.
    classpath = files(tasks.jar.flatMap { it.archiveFile }) +
        sourceSets.test.get().output + configurations.testRuntimeClasspath.get()
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
    val awsSdkVersion = "2.57.1"
    val jacksonVersion = "2.22.4"
    val jacksonDatabindVersion = "2.22.4"
    val jackson3Version = "3.2.4"
    val jackson3DatabindVersion = "3.2.4"
    val log4jVersion = "2.26.1"

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
    // `api`: Jackson 2 types appear in the public JacksonJsonpMapper signatures.
    api("com.fasterxml.jackson.core", "jackson-core", jacksonVersion)
    api("com.fasterxml.jackson.core", "jackson-databind", jacksonDatabindVersion)
    // Optional Java 21 adapter: these dependencies are not required by Java 8 consumers.
    add(jackson3SourceSet.compileOnlyConfigurationName, "tools.jackson.core:jackson-core:$jackson3Version")
    add(jackson3SourceSet.compileOnlyConfigurationName, "tools.jackson.core:jackson-databind:$jackson3DatabindVersion")
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

    testImplementation("org.apache.logging.log4j", "log4j-api", log4jVersion) {
        exclude(group = "com.github.spotbugs", module = "spotbugs-annotations")
    }
    testImplementation("org.apache.logging.log4j", "log4j-core", log4jVersion) {
        exclude(group = "com.github.spotbugs", module = "spotbugs-annotations")
    }

    // EPL-2.0 OR BSD-3-Clause
    // https://eclipse-ee4j.github.io/yasson/
    implementation("org.eclipse", "yasson", "2.0.2")

    // https://github.com/classgraph/classgraph
    testImplementation("io.github.classgraph:classgraph:6.0.2")

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

publishing {
    repositories {
        // Offline verification repo: `publishMavenPublicationToLocalRepoRepository`
        // writes the full publication (jar, sources, javadoc, POM, module metadata,
        // and signatures) under the root build dir so it can be inspected without
        // touching the Central Portal.
        maven(rootProject.layout.buildDirectory.dir("repository")) {
            name = "localRepo"
        }
    }
}

mavenPublishing {
    // USER_MANAGED: the plugin uploads to the Central Portal but does not auto-release.
    // A maintainer publishes the deployment from the Portal UI. Use
    // `publishAndReleaseToMavenCentral` only to auto-release.
    publishToMavenCentral()
    // Sign only when a key is provided, so local publishing works without one.
    // Uploading to Maven Central without a key is rejected below.
    if (!providers.gradleProperty("signingInMemoryKey").orNull.isNullOrBlank()) {
        signAllPublications()
    }
    coordinates("software.amazon.opensearch", "opensearch-java", project.version.toString())
    pom {
        name.set("AWS OpenSearch Java Data Client")
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

// `prepareMavenCentralPublishing` is shared by `publishToMavenCentral` and
// `publishAndReleaseToMavenCentral`, so the guard covers both.
tasks.named("prepareMavenCentralPublishing") {
    val releaseVersion = project.version.toString()
    val signingKey = providers.gradleProperty("signingInMemoryKey")
    doFirst {
        if (signingKey.orNull.isNullOrBlank()) {
            throw GradleException(
                "Refusing to upload unsigned artifacts to Maven Central. " +
                    "Set the signingInMemoryKey property (ORG_GRADLE_PROJECT_signingInMemoryKey) " +
                    "to the ASCII-armored signing key."
            )
        }
        if (releaseVersion.endsWith("SNAPSHOT")) {
            throw GradleException(
                "Maven Central requires a release version, but the version is '" + releaseVersion +
                    "'. Set the VERSION environment variable, e.g. VERSION=x.y.z. " +
                    "(-Dversion only sets the base version and still yields a snapshot.)"
            )
        }
    }
}

tasks.withType<Test>().configureEach {
    if (name != "java8Test" && name != "jackson3Test") {
        dependsOn("awsRuntimeClasses", "aosClasses", "aossClasses")
        classpath += awsRuntimeSourceSet.output + aosSourceSet.output + aossSourceSet.output
    }
}
