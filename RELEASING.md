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

This project is a **pre-release prototype** (version `0.1.0`). Publishing uses the
vanniktech `gradle-maven-publish-plugin`, which uploads to the Central Portal for
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

## Branching

- **main** — all merges land here; it tracks the next release line.
- **`<major>.x` / `<major>.<minor>`** — release branches, created only when a
  release line is actually cut. None exist yet.

This fork **backports manually**: cherry-pick the change onto the target release
branch and open a PR against it. There is no automated backport workflow.

## Releases

The [vanniktech `gradle-maven-publish-plugin`](https://vanniktech.github.io/gradle-maven-publish-plugin/)
builds, signs, and uploads the publication to the Central Portal. It configures
the sources and Javadoc JARs, PGP signing, and the Portal upload, replacing the
hand-written `maven-publish` configuration.

The publication includes the library, sources, and Javadoc JARs, POM, Gradle
module metadata, and PGP signatures. The plugin uploads the deployment in
`USER_MANAGED` mode: it becomes visible in the Central Portal for validation but
is **not** published to Maven Central automatically. A maintainer publishes it
from the Portal after verifying the artifacts. Running
`publishAndReleaseToMavenCentral` instead would auto-release, which this project
deliberately does not do.

### Credentials

The release workflow reads these secrets from AWS Secrets Manager in the team's
release account, in `us-west-2`:

| Secret | Contents |
| --- | --- |
| `opensearch-java/release/gpg-signing-key` | ASCII-armored PGP private key |
| `opensearch-java/release/gpg-passphrase` | Signing key passphrase |
| `opensearch-java/release/central-portal-token` | JSON with `username` and `token`, the Central Portal user token |

Generate the Central Portal user token from the team account authorized to publish
`software.amazon.opensearch`. The plugin uses this token to upload to the Portal.
Verify the stored credentials and upload access before the first release.

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
| `ORG_GRADLE_PROJECT_mavenCentralUsername` | `mavenCentralUsername` |
| `ORG_GRADLE_PROJECT_mavenCentralPassword` | `mavenCentralPassword` |
| `ORG_GRADLE_PROJECT_signingInMemoryKey` | `signingInMemoryKey` |
| `ORG_GRADLE_PROJECT_signingInMemoryKeyPassword` | `signingInMemoryKeyPassword` |

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
     :java-client:publishToMavenCentral
   ```

   Gradle builds and signs the artifacts before uploading them. Snapshot versions
   are rejected by the publish task, and release publications require a signing
   key. The plugin uploads the deployment to the Central Portal in `USER_MANAGED`
   mode. A failed upload fails the workflow;
   the draft GitHub release is created only after the upload succeeds.
3. Open <https://central.sonatype.com/publishing/deployments> and inspect the
   uploaded deployment's artifacts. Wait for `VALIDATED`; the artifacts are
   not on Maven Central yet.
4. **Publish** the validated deployment in Central Portal. Publishing cannot be
   undone — Maven Central does not allow deleting or replacing a version. To
   abandon a release instead, **Drop** the deployment.
5. Confirm that a consuming Maven or Gradle project can resolve the artifacts
   from Maven Central, then publish the draft GitHub release.

### Verifying artifacts locally

Publish an unsigned local snapshot without Sonatype credentials. Signing is
enabled only when the `signingInMemoryKey` property is set. Uploading to
Maven Central without it fails.

```bash
./gradlew --no-daemon :java-client:publishMavenPublicationToLocalRepoRepository
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
