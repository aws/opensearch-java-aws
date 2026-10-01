- [Overview](#overview)
- [Project status](#project-status)
- [Versioning](#versioning)
- [Branching](#branching)
- [Snapshots](#snapshots)
- [Releases](#releases)
- [CHANGELOG entries](#changelog-entries)

## Overview

This document describes how `aws/opensearch-java-aws` is versioned, how snapshots
are published, and the current state of the release-to-Maven-Central process. It
replaces the release strategy inherited from upstream `opensearch-java`, which
does not apply to this fork.

## Project status

This project is a **pre-release prototype** (version `0.1.0`). The final Maven
coordinate, POM metadata, signing keys, and the production release process to
Maven Central have **not been finalized**. Until they are, only snapshots are
published; there is no tagged GA release flow yet.

## Versioning

The version lives in `systemProp.version` in [gradle.properties](gradle.properties)
(currently `0.1.0`). The build appends `-SNAPSHOT` unless a concrete `VERSION`
environment variable or `-Dversion=` system property is supplied, so ordinary
builds produce snapshot artifacts.

The [bump-version workflow](.github/workflows/bump-version.yml) opens a PR to set
`systemProp.version` on a new branch or tag. It can be run manually
(`workflow_dispatch`) or fires automatically on branch/tag creation for this repo.

## Branching

- **main** — all merges land here; it tracks the next release line.
- **`<major>.x` / `<major>.<minor>`** — release branches, created only when a
  release line is actually cut. None exist yet.

This fork **backports manually**: cherry-pick the change onto the target release
branch and open a PR against it. There is no automated backport workflow.

## Snapshots

Snapshots publish automatically from CI on every push to `main` (and to a
`<major>.x` release branch) via the
[publish-snapshots workflow](.github/workflows/publish-snapshots.yml). It
authenticates to AWS with GitHub OIDC (no long-lived credentials) and publishes
the snapshot JARs. Maven Central does not require snapshots to be PGP-signed, so
no signing key is involved in the snapshot path.

## Releases

**No production release workflow exists yet.** Publishing a signed GA artifact to
Maven Central requires several things this fork has not yet set up:

- a Maven Central (Sonatype) namespace grant for the `software.amazon.opensearch`
  group ID, and a dedicated, non-admin publishing token;
- a PGP signing key generated for this project, with the private key and
  passphrase stored in a team-owned secret store (AWS Secrets Manager or a
  protected GitHub Actions environment) readable only by the release job;
- a release workflow that runs only from CI, signs the artifacts, and publishes
  from a protected environment.

The Gradle `signing` block in `java-client/build.gradle.kts` is already wired for
this (it activates only when a signing key is supplied), but the key, the token,
and the release workflow are pending. When they are in place, this section will
document the tag-to-release steps.

The [release-drafter workflow](.github/workflows/release-drafter.yml) drafts
GitHub release notes from merged PRs; it drafts notes only and does not publish
artifacts.

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
