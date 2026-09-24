# CHANGELOG
Inspired from [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [Unreleased 0.1.0]
Initial release of the AWS OpenSearch Java data client, providing typed
data-plane clients for Amazon OpenSearch Service (AOS) and Amazon OpenSearch
Serverless (AOSS).

### Added
- Typed AOS and AOSS data-plane clients under `software.amazon.awssdk.opensearch.client`, generated per distribution into `src/generated/aos` and `src/generated/aoss`.
- Handwritten AOS and AOSS APIs and shared AWS runtime (SigV4 transport, JSON model support).
- `Build Distributions` CI workflow that compiles the AOS and AOSS clients and runs their unit tests across JDK 21 and 25.

### Dependencies

### Changed
- Set the `java-client` compile target to Java 8 to match upstream opensearch-java, so the published client runs on any JVM >= 8 while building with a JDK 17/21 toolchain.
- Moved the code generator to `software.amazon.awssdk.opensearch.client.codegen`, so the emitted `@Generated(...)` marker references a class that exists in this fork.
- Removed the unsupported `refresh` parameter from AOSS multi-get requests.
- Consolidated the handwritten sources into the standard `src/main/java` layout (from `src/java`) and moved `version.properties` to its package resource path, updating the `awsRuntime`/`aos`/`aoss` source sets to match.
- Published the client under the Maven coordinate `software.amazon.opensearch:opensearch-java` (changing only the groupId from the inherited `org.opensearch.client:opensearch-java`), and set the build version to `0.1.0` to match the `[Unreleased 0.1.0]` release line.

### Deprecated

### Removed
- Inherited OpenSearch OSS client sources under `org.opensearch.client.opensearch` and the generated OSS output in `src/generated/java`, which this fork does not ship.
- The gRPC transport module (`java-client-grpc`), its samples, and the gRPC integration-test path.

### Fixed
- Pointed the inherited open-source metadata (CODEOWNERS, MAINTAINERS, ADMINS, NOTICE, SECURITY) at the `aws/amazon-opensearch-clients` owning team and AWS vulnerability reporting.

### Security
- Restricted default GitHub Actions token permissions to read-only for build and maintenance workflows ([#16](https://github.com/aws/opensearch-java-aws/pull/16)).
- Added a `git-secrets` CI workflow and documented the local pre-commit hook to prevent committing secrets.
