/*
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
    targetCompatibility = JavaVersion.VERSION_21
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations.compileClasspath {
    // The client JAR includes the shared runtime and both generated distribution source sets.
    attributes.attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE, objects.named(LibraryElements.JAR))
}

dependencies {
    implementation(project(":java-client"))
    implementation("org.apache.logging.log4j:log4j-api:[2.17.1,3.0)")
    runtimeOnly("org.apache.logging.log4j:log4j-core:[2.17.1,3.0)")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j2-impl:[2.17.1,3.0)")
    implementation("tools.jackson.core:jackson-databind:3.2.2")
    implementation("software.amazon.awssdk:sdk-core:[2.21,3.0)")
    implementation("software.amazon.awssdk:auth:[2.21,3.0)")
    implementation("software.amazon.awssdk:http-auth-aws:[2.21,3.0)")
    implementation("software.amazon.awssdk:url-connection-client:[2.21,3.0)")
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
