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

This project is a **pre-release prototype** (version `0.1.0`). The release
mechanics to Maven Central are in place (see [Releases](#releases)) and the
`software.amazon.opensearch` namespace is verified in the Central Portal, but no
tagged release has been cut yet. The upload path has therefore never run against
the live Portal, so cut the first tag as a pre-release version.

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

Releases go to Maven Central through the [Central Publisher
Portal](https://central.sonatype.org/publish/publish-portal-api/). The Portal
replaced the retired OSSRH staging repositories: instead of pushing artifacts one
by one to a staging Nexus, a release is a single zip whose contents follow the
Maven repository layout, uploaded in one request and then released from the Portal
UI.

### Build mechanics

Two Gradle tasks implement this, both in `java-client/build.gradle.kts`:

- `:java-client:centralBundle` publishes the release into `build/repository` via
  the `localRepo` target, then zips it to
  `java-client/build/central-bundle.zip`. It refuses to run for `-SNAPSHOT`
  versions, wipes `build/repository` first so stale artifacts cannot leak into a
  bundle, and excludes `maven-metadata.xml` (the Portal derives coordinates from
  the directory layout and rejects repository-level metadata).
- `:java-client:publishToCentralPortal` uploads that bundle. It defaults to
  `publishingType=USER_MANAGED`, so the deployment waits in the Portal for a
  maintainer to release it rather than going live automatically. Pass
  `-PcentralPublishingType=AUTOMATIC` to skip that gate — note this cannot be
  undone, since Maven Central does not allow deleting a published version.

Use `:java-client:checkCentralPortalStatus -PdeploymentId=<id>` to poll a
deployment.

### Credentials

The release credentials live in AWS Secrets Manager in account `984220191423`
(`us-west-2`), and nowhere else:

| Secret | Contents |
| --- | --- |
| `opensearch-java/release/gpg-signing-key` | ASCII-armored PGP private key |
| `opensearch-java/release/gpg-passphrase` | its passphrase |
| `opensearch-java/release/central-portal-token` | JSON with `username` and `token` |
| `opensearch-java/release/gpg-revocation-cert` | revocation certificate; not read by CI |

GitHub holds no copy. The release job assumes an IAM role by OIDC and reads them
at run time, so rotating a credential touches one place and every retrieval is
recorded in CloudTrail. The only GitHub secret is
`MAVEN_CENTRAL_SIGNING_ROLE`, the role ARN, which is not sensitive.

The role's trust policy must pin the subject exactly:

```json
"Condition": {
  "StringEquals": {
    "token.actions.githubusercontent.com:aud": "sts.amazonaws.com",
    "token.actions.githubusercontent.com:sub": "repo:aws/opensearch-java-aws:environment:maven-central"
  }
}
```

`StringEquals`, not `StringLike`, and no wildcards: the `environment:maven-central`
segment is what makes the reviewer gate a security control rather than a prompt.
A workflow that never enters the environment cannot assume the role, and a fork
cannot either, because GitHub signs the repository into the `sub` claim. Grant the
role only `secretsmanager:GetSecretValue` on
`arn:aws:secretsmanager:us-west-2:984220191423:secret:opensearch-java/release/*`.

The signing key's **public** half must be published to a keyserver the Portal
checks (`keyserver.ubuntu.com` or `keys.openpgp.org`) or validation fails with an
unverifiable signature. Current key: `A9FC32A0AA70D58C`, fingerprint
`0D84956F0DCA5BB0A324A1F3A9FC32A0AA70D58C`, expires 2031-10-14.

For a local release build, supply the same values as Gradle properties
(`signingKey`, `signingPassword`, `centralPortalUsername`, `centralPortalToken`)
or the equivalent `ORG_GRADLE_PROJECT_*` / `CENTRAL_PORTAL_*` environment
variables. The `signing` block is inert when no key is given, so ordinary builds
need no credentials.

### Cutting a release

1. Land the version and CHANGELOG changes per [Versioning](#versioning).
2. Tag the release commit and push the tag. The tag must match
   `systemProp.version` (with or without a leading `v`); the
   [release-drafter workflow](.github/workflows/release-drafter.yml) fails fast
   otherwise. It then waits for a reviewer from
   `@aws/amazon-opensearch-clients`, runs the unit tests, builds and signs the
   bundle, uploads it to the Portal, and drafts a GitHub release with that exact
   archive and its SHA-256 attached.
3. Once the deployment reports `VALIDATED` at
   <https://central.sonatype.com/publishing/deployments>, release it from the
   Portal UI.
4. Publish the draft GitHub release.

Artifacts appear on `repo1.maven.org` within minutes of release, but search
indexes can lag by up to a few hours.

### Verifying a bundle locally

A bundle can be built and inspected without any Portal credentials:

```
VERSION=0.1.0 ./gradlew :java-client:centralBundle
unzip -l java-client/build/central-bundle.zip
```

The result must contain the main, `-sources`, and `-javadoc` JARs plus the POM,
each with `.asc`, `.md5`, and `.sha1` companions. Signatures only appear when a
signing key is supplied.

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
