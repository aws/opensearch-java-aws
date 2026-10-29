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
- samples: runnable examples using the AWS client JAR

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

Keep the bundled snapshots byte-identical to the published specifications. Express distribution-specific corrections as code generator overrides (`Overrides.forDistribution` in `java-codegen`) rather than editing the snapshots, so a refresh cannot drop them.

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
  :java-client:javadocJar \
  :samples:build
~~~

The build runs on JDK 21 or newer, while the generated Java client targets Java 8 bytecode.

## Samples

Samples target Java 8 and use the Jackson 2 mapper. Gradle requires JDK 21 or newer;
the build CI matrix compiles the samples with `--release 8` and checks their formatting.
See [samples/README.md](samples/README.md) for connection settings and AOS/AOSS run commands.

## Real-resource tests

Real AOS and AOSS tests are opt-in:

~~~bash
./gradlew --no-daemon --max-workers=1 :java-client:realResourceTest
~~~

Provide endpoints and credentials through environment variables or the AWS SDK default credential provider chain. Never commit credentials, passwords, endpoints intended to remain private, or temporary resource identifiers.

## Formatting

~~~bash
./gradlew :java-client:spotlessApply :java-codegen:spotlessApply :samples:spotlessApply
~~~

## Submitting changes

See CONTRIBUTING.md. Commits must include a DCO sign-off.
