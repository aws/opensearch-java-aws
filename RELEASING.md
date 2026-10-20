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
publication to Sonatype's OSSRH Staging API:

```text
https://ossrh-staging-api.central.sonatype.com/service/local/staging/deploy/maven2/
```

This compatibility service accepts uploads from Gradle's standard `maven-publish`
plugin. See Sonatype's public [OSSRH Staging API documentation](https://central.sonatype.org/publish/publish-portal-ossrh-staging-api/)
for repository configuration and transferring deployments to the Central Publisher
Portal.

The publication includes the library, sources, and Javadoc JARs, POM, Gradle
module metadata, and PGP signatures. A maintainer publishes the deployment from
the Central Portal after verifying the artifacts.

Staging repositories created through this API are **isolated by IP**, so a
release has to be uploaded by a single job. Splitting the upload across runners
would scatter the artifacts across separate staging repositories.

### Credentials

The release workflow reads these secrets from AWS Secrets Manager in the team's
release account, in `us-west-2`:

| Secret | Contents |
| --- | --- |
| `opensearch-java/release/gpg-signing-key` | ASCII-armored PGP private key |
| `opensearch-java/release/gpg-passphrase` | Signing key passphrase |
| `opensearch-java/release/central-portal-token` | JSON with `username` and `token`, the Central Portal user token |

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
| `ORG_GRADLE_PROJECT_centralPortalUsername` | `centralPortalUsername` |
| `ORG_GRADLE_PROJECT_centralPortalToken` | `centralPortalToken` |
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
     :java-client:publishPublishMavenPublicationToCentralStagingRepository
   ```

   Gradle builds and signs the artifacts before uploading them. Snapshot versions
   are rejected by the staging task, and release publications require a signing
   key. The workflow then creates a draft GitHub release with the JARs and their
   signatures attached.
3. Open <https://central.sonatype.com/publishing/deployments>. A staging
   repository has to be closed, or uploaded manually, before it appears there.
   Inspect the deployment's artifacts; it reaches `VALIDATED` once Sonatype's
   checks pass, and nothing is on Maven Central until it is published.
4. Verify that a consuming Maven or Gradle project can resolve the client from
   the staging repository, then **Publish** the deployment. Publishing cannot be
   undone — Maven Central does not allow deleting or replacing a version. To
   abandon a release instead, **Drop** the deployment.
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
