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

The `Validate AWS Generated Sources` workflow refreshes the snapshots every Monday (or on demand via *Run workflow*) and opens a pull request labeled `autocut` with the updated specs, checksums and generated sources. Pull requests opened with the workflow token do not trigger other workflows; close and reopen the pull request to run the checks.

Each distribution is generated with a maximum OpenSearch version (`--max-version`, set per distribution in `java-codegen/build.gradle.kts`: AOS `3.7`, AOSS `3.3`). Operations, properties and `anyOf`/`oneOf`/`allOf` members whose `x-version-added` is newer are not generated; raise the version when the service supports a newer OpenSearch release.

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

## Dependency verification

Gradle verifies every downloaded artifact against the SHA-256 checksums in
[gradle/verification-metadata.xml](gradle/verification-metadata.xml). After adding or
upgrading a dependency or plugin, add its checksums:

~~~bash
./gradlew --no-daemon --write-verification-metadata sha256 resolveDependencies
~~~

`resolveDependencies` resolves every configuration of `java-client`, `java-codegen` and
`samples`, plus the build script classpaths. Commit the updated metadata with the
dependency change. Gradle does not remove entries for versions that are no longer used.

The Dependabot PR workflow runs the same command on Dependabot pull requests. When
reviewing one, check that the metadata diff only adds the upgraded artifacts and their
new transitive dependencies, all from the expected groups.

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

## Automation bot

Two workflows act as the `opensearch-aws-client-bot` GitHub user, so that their pushes
and pull requests trigger the pull request checks (pushes made with `GITHUB_TOKEN` do not):

- [Bump Version](.github/workflows/bump-version.yml): after a GitHub release is published,
  opens a pull request that moves `main` to the next development version.
- [Dependabot PR](.github/workflows/dependabot-pr.yml): adds the `### Dependencies`
  CHANGELOG entry and the new dependency checksums to Dependabot pull requests labeled
  `dependabot`. Its Gradle run gets no token; a separate job commits the two files and
  pushes them as the bot.

The bot has write access to this repository only. Its fine-grained personal access token,
scoped to `aws/opensearch-java-aws` with `Contents` and `Pull requests` read and write, is
stored as `BOT_TOKEN` twice, because workflows triggered by Dependabot only see Dependabot
secrets:

~~~bash
gh secret set BOT_TOKEN -R aws/opensearch-java-aws                  # Actions secret
gh secret set BOT_TOKEN -R aws/opensearch-java-aws --app dependabot # Dependabot secret
~~~

The token expires after 90 days. Generate a new one as the bot before then and update both
secrets.

## Formatting

~~~bash
./gradlew :java-client:spotlessApply :java-codegen:spotlessApply :samples:spotlessApply
~~~

## Submitting changes

See CONTRIBUTING.md. Commits must include a DCO sign-off.
