# CHANGELOG
Inspired from [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [Unreleased 0.1.0]
Initial release of the AWS OpenSearch Java data client, providing typed
data-plane clients for Amazon OpenSearch Service (AOS) and Amazon OpenSearch
Serverless (AOSS).

### Added
- Pinned each input spec with a committed `<spec>.sha256` checksum, verified before generating — the same approach OpenSearch core uses for its `<jar>.sha1` dependency pins. The `code-generation` workflow now runs on pull requests and fails if regenerating from the committed specs drifts from the committed output ([#35](https://github.com/aws/opensearch-java-aws/pull/35)).
- Bundled AOS and AOSS OpenAPI snapshots as the default inputs for distribution client generation ([#14](https://github.com/aws/opensearch-java-aws/pull/14)).
- Typed AOS and AOSS data-plane clients under `software.amazon.opensearch.client`, generated per distribution into `src/generated/aos` and `src/generated/aoss`.
- Handwritten AOS and AOSS APIs and shared AWS runtime (SigV4 transport, JSON model support).
- `Build Distributions` CI workflow that compiles the AOS and AOSS clients and runs their unit tests across JDK 21 and 25.

### Dependencies

### Changed
- Include Java 8-compatible `samples` in Gradle and CI builds, align examples with the AWS client packages and APIs, and add AOS/AOSS search examples and usage documentation ([#43](https://github.com/aws/opensearch-java-aws/pull/43)).
- Resolve build plugins and dependencies from Maven Central only ([#36](https://github.com/aws/opensearch-java-aws/pull/36)).
- Dropped the unused `opensearch.repositories` plugin and pinned the AWS SDK and log4j dependencies to fixed versions instead of ranges ([#45](https://github.com/aws/opensearch-java-aws/pull/45)).
- Added Gradle dependency verification so build artifacts are checked against recorded SHA-256 checksums ([#45](https://github.com/aws/opensearch-java-aws/pull/45)).
- Compatibility: `AwsSdk2Transport` now throws `TransportException` before sending a GET body through AWS SDK `UrlConnectionHttpClient`, including explicitly supplied empty bodies. Use an HTTP client that preserves GET bodies, such as AWS CRT, when body fields are set.
- Compatibility: unset optional GET bodies are omitted for AOSS snapshot listing and AOS ML profiling. ML profile calls without body fields now use the server's URL-based defaults and model/task IDs instead of parsing `{}`, which can change returned results. Explicit false values, empty collections, and generic request bodies are preserved.
- Rewrote `RELEASING.md` for this fork: documents the `0.1.0` prototype status, snapshot publishing via GitHub Actions OIDC, manual backporting, and that the signed Maven Central release path is not yet established — replacing the inherited upstream Jenkins/opensearch.org release strategy.
- Set the `java-client` compile target to Java 8 to match upstream opensearch-java, so the published client runs on any JVM >= 8 while building with JDK 21 or newer.
- Moved the code generator to `software.amazon.opensearch.client.codegen`, so the emitted `@Generated(...)` marker references a class that exists in this fork.
- Removed the unsupported `refresh` parameter from AOSS multi-get requests.
- Consolidated the handwritten sources into the standard `src/main/java` layout (from `src/java`) and moved `version.properties` to its package resource path, updating the `awsRuntime`/`aos`/`aoss` source sets to match.
- Published the client under the Maven coordinate `software.amazon.opensearch:opensearch-java` (changing only the groupId from the inherited `org.opensearch.client:opensearch-java`), and set the build version to `0.1.0` to match the `[Unreleased 0.1.0]` release line.

### Deprecated

### Removed
- The snapshot publishing path: the `publish-snapshots.yml` workflow and the remote `Snapshots` publishing repository in `java-client/build.gradle.kts`. This fork's up/downstream consumers do not integrate against snapshots, so the only publishing path is the signed Maven Central release. Local snapshot builds still work via the `localRepo` repository.
- The inherited `Backport` workflow (`.github/workflows/backport.yml`) and the upstream Jenkins release pipeline (`jenkins/release.jenkinsFile`), both dead scaffolding from upstream opensearch-java: the backport job was guarded to `opensearch-project/opensearch-java` so it never ran here (this fork backports manually per `RELEASING.md`), and the Jenkins file targets the opensearch.org build system this fork does not use.
- Inherited OpenSearch OSS client sources under `org.opensearch.client.opensearch` and the generated OSS output in `src/generated/java`, which this fork does not ship.
- The gRPC transport module (`java-client-grpc`), its samples, and the gRPC integration-test path.

### Fixed
- Reject spec names that are not plain identifiers so they cannot break out of generated comments ([#44](https://github.com/aws/opensearch-java-aws/pull/44)).
- Escaped backslashes and comment terminators in spec descriptions so they no longer break the generated Javadoc comment, and made the generator fail if the rendered doc would still contain a backslash-u sequence. Generation now also fails if the Java formatter cannot format its output, instead of silently emitting unformatted code. Regenerating under the new escaping updated five generated files ([#35](https://github.com/aws/opensearch-java-aws/pull/35)).
- Accept AOS search-shards node responses that omit attributes and transport addresses, and segment responses that omit attributes, compound flags, or versions. `Segment.compound()` and its builder setter now use nullable `Boolean`; consumers should recompile and handle absent values.
- Preserve optional GET body presence through client generation and transport processing, so requests with no body fields set do not send an unnecessary `{}`.
- Pointed the `bump-version` auto-bump job's repository guard and the generated jar's `Implementation-URL` manifest attribute at `aws/opensearch-java-aws` instead of the inherited `opensearch-project/opensearch-java`.
- Pointed the inherited open-source metadata (CODEOWNERS, MAINTAINERS, ADMINS, NOTICE, SECURITY) at the `aws/amazon-opensearch-clients` owning team and AWS vulnerability reporting.

### Security
- Restricted default GitHub Actions token permissions to read-only for build and maintenance workflows ([#16](https://github.com/aws/opensearch-java-aws/pull/16)).
- Added a `git-secrets` CI workflow and documented the local pre-commit hook to prevent committing secrets.
- Extended the `git-secrets` scan with patterns for this project's release secrets (the PGP signing key and the Sonatype/Nexus publishing token), fixed the private-key patterns so git-secrets' internal grep no longer rejects the leading dash, and scoped the self-referential false positives in `.gitallowed` by file path.
- Added a `zizmor` CI workflow that statically scans the GitHub Actions workflows and uploads findings to the Security tab.
- Migrated the `AOS and AOSS Real Resource Tests` workflow from long-lived `AWS_ACCESS_KEY_ID`/`AWS_SECRET_ACCESS_KEY`/`AWS_SESSION_TOKEN` secrets to GitHub Actions OIDC role assumption, so CI holds no long-lived AWS credentials.
