- [Overview](#overview)
- [Project status](#project-status)
- [Versioning](#versioning)
- [Branching](#branching)
- [Releases](#releases)
- [CHANGELOG entries](#changelog-entries)

## Overview

This document describes how `aws/opensearch-java-aws` is versioned and the
current state of the release-to-Maven-Central process. It replaces the release
strategy inherited from upstream `opensearch-java`, which does not apply to this
fork.

## Project status

This project is a **pre-release prototype** (version `0.1.0`). Publishing is
configured for AWS Sonatype staging. Before the first release, confirm that the
team account can publish `software.amazon.opensearch` through that endpoint.
The live staging upload has not yet been validated.

## Versioning

The version lives in `systemProp.version` in [gradle.properties](gradle.properties)
(currently `0.1.0`). Only the `VERSION` environment variable produces a release
version:

```kotlin
version = System.getenv("VERSION") ?: System.getProperty("version") + "-SNAPSHOT"
```

`-Dversion=0.1.0` sets the *base* version and still yields `0.1.0-SNAPSHOT`, so
ordinary and snapshot builds need no extra flags, and a release build must set
`VERSION=0.1.0`.

The [bump-version workflow](.github/workflows/bump-version.yml) opens a PR to set
`systemProp.version` on a new branch or tag. It can be run manually
(`workflow_dispatch`) or fires automatically on branch/tag creation for this repo.

## Branching

- **main** — all merges land here; it tracks the next release line.
- **`<major>.x` / `<major>.<minor>`** — release branches, created only when a
  release line is actually cut. None exist yet.

This fork **backports manually**: cherry-pick the change onto the target release
branch and open a PR against it. There is no automated backport workflow.

## Releases

The Gradle `maven-publish` and `signing` plugins build, sign, and upload the
publication to AWS Sonatype staging:

```text
https://aws.oss.sonatype.org/service/local/staging/deploy/maven2/
```

The publication includes the library, sources, and Javadoc JARs, POM, Gradle
module metadata, and PGP signatures. A maintainer closes and releases the staging
repository in the Sonatype web UI after verifying the artifacts.

### Credentials

The release workflow reads these secrets from AWS Secrets Manager in the team's
release account, in `us-west-2`:

| Secret | Contents |
| --- | --- |
| `opensearch-java/release/gpg-signing-key` | ASCII-armored PGP private key |
| `opensearch-java/release/gpg-passphrase` | Signing key passphrase |
| `opensearch-java/release/sonatype-credentials` | JSON with `username` and `password` for AWS Sonatype staging |

The staging account must have publishing access to `software.amazon.opensearch`.
An existing Central Portal account or namespace approval does not by itself
confirm access to the AWS staging endpoint. Configure and verify the staging
credentials before triggering a release.

Configure required reviewers and the `MAVEN_CENTRAL_SIGNING_ROLE` secret on the
GitHub `release` environment. The role must allow `secretsmanager:GetSecretValue`
for the three secrets above and trust this OIDC subject:

```json
"Condition": {
  "StringEquals": {
    "token.actions.githubusercontent.com:aud": "sts.amazonaws.com",
    "token.actions.githubusercontent.com:sub": "repo:aws/opensearch-java-aws:environment:release"
  }
}
```

The workflow passes credentials through Gradle's environment properties:

| Environment variable | Gradle property |
| --- | --- |
| `ORG_GRADLE_PROJECT_mavenUsername` | `mavenUsername` |
| `ORG_GRADLE_PROJECT_mavenPassword` | `mavenPassword` |
| `ORG_GRADLE_PROJECT_signingKey` | `signingKey` |
| `ORG_GRADLE_PROJECT_signingPassword` | `signingPassword` |

Keep the project private key and credentials in the team-owned secret store.
Publish the signing public key to a keyserver accepted by Sonatype, such as
`keyserver.ubuntu.com` or `keys.openpgp.org`.

### Cutting a release

1. Land the version and CHANGELOG changes per [Versioning](#versioning).
2. Push a tag matching `v<systemProp.version>`, for example `v0.1.0`, to the
   official repository. The [release workflow](.github/workflows/release.yml)
   waits for environment approval, runs unit tests, and invokes:

   ```bash
   VERSION=0.1.0 ./gradlew --no-daemon \
     :java-client:publishPublishMavenPublicationToSonatypeStagingRepository
   ```

   Gradle builds and signs the artifacts before uploading them. Snapshot versions
   are rejected by the staging task, and release publications require a signing
   key. The workflow then creates a draft GitHub release with the JARs and their
   signatures attached.
3. Open the staging repositories in the AWS Sonatype web UI:
   `https://aws.oss.sonatype.org/#stagingRepositories`. Find this release's staging
   repository, inspect its artifacts, and **Close** it.
4. Use the staging repository URL shown by Sonatype to verify that a consuming
   Maven or Gradle project can resolve and use the client. Then **Release** the
   staging repository to Maven Central.
5. Publish the draft GitHub release after confirming the Maven Central artifacts
   are available.

### Verifying artifacts locally

Publish an unsigned local snapshot without Sonatype credentials:

```bash
./gradlew --no-daemon :java-client:publishPublishMavenPublicationToLocalRepoRepository
```

Inspect the publication under
`build/repository/software/amazon/opensearch/opensearch-java/0.1.0-SNAPSHOT/`.
It must include the library, sources, and Javadoc JARs, POM, and Gradle module
metadata.

For local signing validation, use a throwaway key through the signing properties
above and set `VERSION=0.1.0` for the same local repository task. Verify each
artifact's `.asc` signature with `gpg --verify`. Local publication validates the
artifact layout and signing; it does not validate access to the AWS staging
service.

## CHANGELOG entries

Keep the unreleased section of [CHANGELOG.md](CHANGELOG.md) in this shape, moving
entries under the matching heading:

```markdown
## [Unreleased 0.1.0]
### Added
### Dependencies
### Changed
### Deprecated
### Removed
### Fixed
### Security
```

When a version is released, replace the `## [Unreleased x.y]` heading with the
released version and date.
