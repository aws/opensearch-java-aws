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

This project is a **pre-release prototype** (version `0.1.0`). Publishing uses
Sonatype's OSSRH Staging API and transfers the deployment to Central Portal for
manual publication. The live upload and team publishing credentials have not yet
been validated.

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

After Gradle uploads all artifacts, the same workflow step calls Sonatype's
`POST /manual/upload/defaultRepository/software.amazon.opensearch` endpoint with
`publishing_type=user_managed`. This makes the deployment visible in Central
Portal for validation and manual publication. It does not publish to Maven
Central automatically. The request uses a Bearer token built from the existing
Central Portal token username and password.

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

Generate the Central Portal user token from the team account authorized to publish
`software.amazon.opensearch`. The workflow uses this token for both the artifact
uploads and the transfer to Central Portal. Verify the stored credentials and
upload access before the first release.

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
   uses the `release` environment, runs unit tests, and invokes:

   ```bash
   VERSION=0.1.0 ./gradlew --no-daemon \
     :java-client:publishPublishMavenPublicationToCentralStagingRepository
   ```

   Gradle builds and signs the artifacts before uploading them. Snapshot versions
   are rejected by the staging task, and release publications require a signing
   key. After the upload, the same runner transfers the deployment to Central
   Portal in `user_managed` mode. A failed upload or transfer fails the workflow;
   the draft GitHub release is created only after both succeed.
3. Open <https://central.sonatype.com/publishing/deployments> and inspect the
   transferred deployment's artifacts. Wait for `VALIDATED`; the artifacts are
   not on Maven Central yet.
4. **Publish** the validated deployment in Central Portal. Publishing cannot be
   undone — Maven Central does not allow deleting or replacing a version. To
   abandon a release instead, **Drop** the deployment.
5. Confirm that a consuming Maven or Gradle project can resolve the artifacts
   from Maven Central, then publish the draft GitHub release.

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
artifact layout and signing; it does not validate access to the live Sonatype
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
