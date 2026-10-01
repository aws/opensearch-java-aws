# Developer Guide

This repository builds typed Java data-plane clients for Amazon OpenSearch Service (AOS) and Amazon OpenSearch Serverless (AOSS).

## Prerequisites

- JDK 21 or newer to run the build; generated client bytecode targets Java 8
- The repository-bundled AOS and AOSS OpenAPI snapshots are sufficient for the default build
- Optional: a directory containing newly generated AOS and AOSS distribution specifications when refreshing the bundled snapshots

## Source layout

- java-client/src/main: shared AWS runtime and handwritten AOS/AOSS client entry points
- java-client/src/generated/aos: generated AOS models and clients
- java-client/src/generated/aoss: generated AOSS models and clients
- java-codegen: the shared OpenAPI Java generator and AWS distribution generation tasks

The repository does not contain or build the standalone OSS opensearch-java client.

## Generate clients

By default, generation reads the bundled snapshots:

- java-codegen/opensearch-openapi-aos.yaml
- java-codegen/opensearch-openapi-aoss.yaml

~~~bash
./gradlew --no-daemon --max-workers=1 :java-codegen:generateClients
~~~

To generate from refreshed specifications, provide the directory containing files with
the same names:

~~~bash
./gradlew --no-daemon --max-workers=1 \
  :java-codegen:generateClients \
  -PdistributionSpecsDir=/path/to/opensearch-api-docs/build
~~~

Do not manually edit generated AOS or AOSS source files. Update the API specification, distribution overlays, allowlists, or generator instead.

## Build and test

~~~bash
./gradlew --no-daemon --max-workers=1 \
  :java-codegen:test \
  :java-client:unitTest \
  :java-client:spotlessJavaCheck \
  :java-codegen:spotlessJavaCheck \
  :java-client:jar \
  :java-client:sourcesJar \
  :java-client:javadocJar
~~~

The build runs on JDK 21 or newer, while the generated Java client targets Java 8 bytecode.

## Real-resource tests

Real AOS and AOSS tests are opt-in:

~~~bash
./gradlew --no-daemon --max-workers=1 :java-client:realResourceTest
~~~

Provide endpoints and credentials through environment variables or the AWS SDK default credential provider chain. Never commit credentials, passwords, endpoints intended to remain private, or temporary resource identifiers.

## Formatting

~~~bash
./gradlew :java-client:spotlessApply :java-codegen:spotlessApply
~~~

## Submitting changes

See CONTRIBUTING.md. Commits must include a DCO sign-off.
