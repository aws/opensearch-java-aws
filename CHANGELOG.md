# CHANGELOG
Inspired from [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [Unreleased 0.1.0]
Initial release of the AWS OpenSearch Java data client, providing typed
data-plane clients for Amazon OpenSearch Service (AOS) and Amazon OpenSearch
Serverless (AOSS).

### Added
- Add `search_pipeline` to AOS and AOSS `_msearch` sub-request bodies (`MultisearchBody.searchPipeline`); previously the field could not be set and was dropped when a body was deserialized and re-serialized (ported from upstream [opensearch-java#2206](https://github.com/opensearch-project/opensearch-java/pull/2206)).
- Add `FieldValue.FIRST` and `FieldValue.LAST` constants for the `_first` and `_last` sort values to the AOS and AOSS clients (ported from upstream [opensearch-java#2189](https://github.com/opensearch-project/opensearch-java/pull/2189)).
- Pinned each input spec with a committed `<spec>.sha256` checksum, verified before generating — the same approach OpenSearch core uses for its `<jar>.sha1` dependency pins. The `code-generation` workflow now runs on pull requests and fails if regenerating from the committed specs drifts from the committed output ([#35](https://github.com/aws/opensearch-java-aws/pull/35)).
- Add signed Maven Central publishing through the vanniktech `gradle-maven-publish-plugin`, which uploads to the Central Portal for manual publication ([#42](https://github.com/aws/opensearch-java-aws/pull/42)).
- Bundled AOS and AOSS OpenAPI snapshots as the default inputs for distribution client generation ([#14](https://github.com/aws/opensearch-java-aws/pull/14)).
- Typed AOS and AOSS data-plane clients under `software.amazon.opensearch.client`, generated per distribution into `src/generated/aos` and `src/generated/aoss`.
- Handwritten AOS and AOSS APIs and shared AWS runtime (SigV4 transport, JSON model support).
- `Build Distributions` CI workflow that compiles the AOS and AOSS clients and runs their unit tests across JDK 21 and 25.

### Dependencies
- Bump Jackson to `2.22.4` / `3.2.4` and the test-only `io.github.classgraph:classgraph` to `5.0.0` (ported from upstream [opensearch-java#2231](https://github.com/opensearch-project/opensearch-java/pull/2231), [#2228](https://github.com/opensearch-project/opensearch-java/pull/2228)).
- Bumped Spotless to 8.10.4 and the code generator's `spotless-lib-extra` to 4.10.4, so the Eclipse JDT formatter resolves from Maven Central instead of the Eclipse P2 update site in both the build's formatting check and the code generator ([#48](https://github.com/aws/opensearch-java-aws/pull/48)).
- Pin AWS SDK dependencies to `2.57.1`; consumers can override the version with their AWS SDK BOM.

### Changed
- `ApacheHttpClient5Transport` creates the request entity directly on the serialization buffer instead of copying it, halving the memory needed for large bulk requests (ported from upstream [opensearch-java#2196](https://github.com/opensearch-project/opensearch-java/pull/2196)).
- Removed the `Bump Version` and `Dependabot PR actions` workflows along with their dead `create-version-bump-pr` action and `.ci/bump-version.sh` script ([#51](https://github.com/aws/opensearch-java-aws/pull/51)).
- Include Java 8-compatible `samples` in Gradle and CI builds, align examples with the AWS client packages and APIs, and add AOS/AOSS search examples and usage documentation ([#43](https://github.com/aws/opensearch-java-aws/pull/43)).
- Run client and generator tests as part of CI builds ([#43](https://github.com/aws/opensearch-java-aws/pull/43)).
- Resolve build plugins and dependencies from Maven Central only ([#36](https://github.com/aws/opensearch-java-aws/pull/36)).
- Dropped the unused `opensearch.repositories` plugin and pinned the AWS SDK and log4j dependencies to fixed versions instead of ranges ([#45](https://github.com/aws/opensearch-java-aws/pull/45)).
- Added Gradle dependency verification so build artifacts are checked against recorded SHA-256 checksums ([#45](https://github.com/aws/opensearch-java-aws/pull/45)).
- Compatibility: `AwsSdk2Transport` now throws `TransportException` before sending a GET body through AWS SDK `UrlConnectionHttpClient`, including explicitly supplied empty bodies. Use an HTTP client that preserves GET bodies, such as AWS CRT, when body fields are set.
- Compatibility: unset optional GET bodies are omitted for AOSS snapshot listing and AOS ML profiling. ML profile calls without body fields now use the server's URL-based defaults and model/task IDs instead of parsing `{}`, which can change returned results. Explicit false values, empty collections, and generic request bodies are preserved.
- Update `RELEASING.md` with the prototype release process, manual backporting, and publishing through the vanniktech `gradle-maven-publish-plugin`.
- Ship a multi-release JAR with Jackson 2 as the default on Java 8+, and an optional Jackson 3 mapper on Java 21+. Jackson 2 is published at compile scope because its types appear in the public mapper API. Test both mappers against the packaged JAR in CI.
- Moved the code generator to `software.amazon.opensearch.client.codegen`, so the emitted `@Generated(...)` marker references a class that exists in this fork.
- Removed the unsupported `refresh` parameter from AOSS multi-get requests.
- Consolidated the handwritten sources into the standard `src/main/java` layout (from `src/java`) and moved `version.properties` to its package resource path, updating the `awsRuntime`/`aos`/`aoss` source sets to match.
- Published the client under the Maven coordinate `software.amazon.opensearch:opensearch-java` (changing only the groupId from the inherited `org.opensearch.client:opensearch-java`), and set the build version to `0.1.0` to match the `[Unreleased 0.1.0]` release line.
- Hardened the CI workflows: scoped the push and pull-request triggers to `main` and release branches so a feature-branch push no longer runs CI twice, and trimmed the redundant `macOS-14` build-matrix entry ([#48](https://github.com/aws/opensearch-java-aws/pull/48)).
- Fixed the remaining zizmor findings in the CI workflows and the zizmor report upload ([#49](https://github.com/aws/opensearch-java-aws/pull/49)).
- Set `persist-credentials: false` on the read-only checkouts in the CI workflows so the job token is not left in the git config after checkout ([#52](https://github.com/aws/opensearch-java-aws/pull/52)).

### Deprecated

### Removed
- The snapshot publishing path: the `publish-snapshots.yml` workflow and the remote `Snapshots` publishing repository in `java-client/build.gradle.kts`. This fork's up/downstream consumers do not integrate against snapshots, so the only publishing path is the signed Maven Central release. Local snapshot builds still work via the `localRepo` repository.
- The inherited `Backport` workflow (`.github/workflows/backport.yml`) and the upstream Jenkins release pipeline (`jenkins/release.jenkinsFile`), both dead scaffolding from upstream opensearch-java: the backport job was guarded to `opensearch-project/opensearch-java` so it never ran here (this fork backports manually per `RELEASING.md`), and the Jenkins file targets the opensearch.org build system this fork does not use.
- Inherited OpenSearch OSS client sources under `org.opensearch.client.opensearch` and the generated OSS output in `src/generated/java`, which this fork does not ship.
- The gRPC transport module (`java-client-grpc`), its samples, and the gRPC integration-test path.

### Fixed
- Code generator: flatten `properties` declared next to an `allOf` combinator, so the generated AOS and AOSS `TermsLookup` now includes `index`, `path`, `routing` and `store` (ported from upstream [opensearch-java#2239](https://github.com/opensearch-project/opensearch-java/pull/2239)).
- Code generator: model nested sub-aggregations on single-bucket aggregates (`SingleBucketAggregateBase`), and map multi-member `allOf` schemas to their last member instead of failing with a `NullPointerException` (ported from upstream [opensearch-java#1957](https://github.com/opensearch-project/opensearch-java/pull/1957), [#2238](https://github.com/opensearch-project/opensearch-java/pull/2238)).
- `JsonData._DESERIALIZER` reads the value at the current parser event instead of advancing past it, and the `Requests.JsonBodyBuilder.method` null check now reports `method cannot be null` (ported from upstream [opensearch-java#1957](https://github.com/opensearch-project/opensearch-java/pull/1957), [#2229](https://github.com/opensearch-project/opensearch-java/pull/2229)).
- Reject spec names that are not plain identifiers so they cannot break out of generated comments ([#44](https://github.com/aws/opensearch-java-aws/pull/44)).
- Escaped backslashes and comment terminators in spec descriptions so they no longer break the generated Javadoc comment, and made the generator fail if the rendered doc would still contain a backslash-u sequence. Generation now also fails if the Java formatter cannot format its output, instead of silently emitting unformatted code. Regenerating under the new escaping updated five generated files ([#35](https://github.com/aws/opensearch-java-aws/pull/35)).
- Accept AOS search-shards node responses that omit attributes and transport addresses, and segment responses that omit attributes, compound flags, or versions. `Segment.compound()` and its builder setter now use nullable `Boolean`; consumers should recompile and handle absent values.
- Preserve optional GET body presence through client generation and transport processing, so requests with no body fields set do not send an unnecessary `{}`.
- Restrict release publishing to matching `v` tags in the official repository and create GitHub releases as drafts.
- Publish AWS SDK transport dependencies as optional POM dependencies and expose the correct Gradle capability.
- Correct the POM inception year and SCM metadata.
- Pointed the `bump-version` auto-bump job's repository guard and the generated jar's `Implementation-URL` manifest attribute at `aws/opensearch-java-aws` instead of the inherited `opensearch-project/opensearch-java`.
- Pointed the inherited open-source metadata (CODEOWNERS, MAINTAINERS, ADMINS, NOTICE, SECURITY) at the `aws/amazon-opensearch-clients` owning team and AWS vulnerability reporting.
- Pinned the `samples` AWS SDK and log4j dependencies to fixed versions so a clean build no longer resolves a newer release that fails dependency verification ([#52](https://github.com/aws/opensearch-java-aws/pull/52)).

### Security
- Fetch release credentials from AWS Secrets Manager using GitHub OIDC and gate publishing on the `release` environment; mask every non-empty line of the GPG private key in workflow logs.
- Restricted default GitHub Actions token permissions to read-only for build and maintenance workflows ([#16](https://github.com/aws/opensearch-java-aws/pull/16)).
- Added a `git-secrets` CI workflow and documented the local pre-commit hook to prevent committing secrets.
- Extended the `git-secrets` scan with patterns for this project's release secrets (the PGP signing key and the Sonatype/Nexus publishing token), fixed the private-key patterns so git-secrets' internal grep no longer rejects the leading dash, and scoped the self-referential false positives in `.gitallowed` by file path.
- Pinned the remaining floating third-party action references to commit SHAs, and set `persist-credentials: false` on the checkouts that do not push ([#47](https://github.com/aws/opensearch-java-aws/pull/47)).
- Added a `zizmor` CI workflow that statically scans the GitHub Actions workflows and uploads findings to the Security tab.
- Gate the `AOS and AOSS Real Resource Tests` workflow on the `real-resource-tests` environment, so each run needs approval, and fail fast when its secrets are missing instead of skipping every test. The AOS smoke test now signs with SigV4 through the same OIDC role as AOSS instead of a master user password, and both tests take the region from the AWS SDK default region chain ([#53](https://github.com/aws/opensearch-java-aws/pull/53)).
- Migrated the `AOS and AOSS Real Resource Tests` workflow from long-lived `AWS_ACCESS_KEY_ID`/`AWS_SECRET_ACCESS_KEY`/`AWS_SESSION_TOKEN` secrets to GitHub Actions OIDC role assumption, so CI holds no long-lived AWS credentials.
