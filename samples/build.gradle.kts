/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

plugins {
    java
    application

    id("opensearch-java.spotless-conventions")
}

java {
    targetCompatibility = JavaVersion.VERSION_1_8
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(8)
}

configurations.compileClasspath {
    // The client JAR includes the shared runtime and both generated distribution source sets.
    attributes.attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, objects.named(LibraryElements.JAR))
}

dependencies {
    implementation(project(":java-client")) {
        // Samples explicitly use the Java 8-compatible Jackson 2 mapper.
        exclude(group = "tools.jackson.core")
    }
    val log4jVersion = "2.26.1"
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    runtimeOnly("org.apache.logging.log4j:log4j-core:$log4jVersion")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j2-impl:$log4jVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.22.4")
    val awsSdkVersion = "2.57.1"
    implementation("software.amazon.awssdk:sdk-core:$awsSdkVersion")
    implementation("software.amazon.awssdk:auth:$awsSdkVersion")
    implementation("software.amazon.awssdk:http-auth-aws:$awsSdkVersion")
    implementation("software.amazon.awssdk:url-connection-client:$awsSdkVersion")
}

application {
    mainClass.set("software.amazon.opensearch.client.samples.Main")
}

tasks.named<JavaExec>("run") {
    systemProperty("samples.mainClass", System.getProperty("samples.mainClass"))
}

tasks.build {
    dependsOn("spotlessJavaCheck")
}
