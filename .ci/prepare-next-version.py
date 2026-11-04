#!/usr/bin/env python3
#
# Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License").
# You may not use this file except in compliance with the License.
# A copy of the License is located at
#
#  http://aws.amazon.com/apache2.0
#
# or in the "license" file accompanying this file. This file is distributed
# on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
# express or implied. See the License for the specific language governing
# permissions and limitations under the License.
#
"""Move the repository to the next development version after a release.

Usage: prepare-next-version.py <released-version> <next-version> [<release-date>]

- gradle.properties: systemProp.version becomes <next-version>. Builds without the
  VERSION environment variable then produce <next-version>-SNAPSHOT.
- CHANGELOG.md: "## [Unreleased <released-version>]" becomes
  "## [<released-version>] - <release-date>", and an empty
  "## [Unreleased <next-version>]" section is added above it.

Running it again for the same versions changes nothing.
"""

import datetime
import re
import sys
from pathlib import Path

VERSION = re.compile(r"^\d+\.\d+\.\d+$")
SECTIONS = ["Added", "Dependencies", "Changed", "Deprecated", "Removed", "Fixed", "Security"]


def bump_gradle_properties(path: Path, released: str, next_version: str) -> bool:
    text = path.read_text()
    match = re.search(r"^systemProp\.version\s*=\s*(\S+)\s*$", text, re.MULTILINE)
    if not match:
        sys.exit(f"{path}: systemProp.version not found")
    current = match.group(1)
    if current == next_version:
        return False
    if current != released:
        sys.exit(f"{path}: systemProp.version is {current}, expected the released version {released}")
    path.write_text(text[: match.start(1)] + next_version + text[match.end(1) :])
    return True


def bump_changelog(path: Path, released: str, next_version: str, date: str) -> bool:
    text = path.read_text()
    unreleased_next = f"## [Unreleased {next_version}]"
    if unreleased_next in text:
        return False
    unreleased = f"## [Unreleased {released}]"
    if unreleased not in text:
        sys.exit(f"{path}: heading '{unreleased}' not found")
    new_section = "\n".join([unreleased_next] + [f"### {s}" for s in SECTIONS]) + "\n\n"
    released_heading = f"## [{released}] - {date}"
    path.write_text(text.replace(unreleased, new_section + released_heading, 1))
    return True


def main(argv):
    if len(argv) not in (3, 4):
        sys.exit(__doc__)
    released, next_version = argv[1], argv[2]
    date = argv[3] if len(argv) == 4 else datetime.date.today().isoformat()
    for name, value in (("released version", released), ("next version", next_version)):
        if not VERSION.match(value):
            sys.exit(f"Invalid {name} '{value}': expected MAJOR.MINOR.PATCH")
    if tuple(map(int, next_version.split("."))) <= tuple(map(int, released.split("."))):
        sys.exit(f"Next version {next_version} must be greater than {released}")
    if not re.match(r"^\d{4}-\d{2}-\d{2}$", date):
        sys.exit(f"Invalid release date '{date}': expected YYYY-MM-DD")

    root = Path(__file__).resolve().parent.parent
    changed = bump_gradle_properties(root / "gradle.properties", released, next_version)
    changed |= bump_changelog(root / "CHANGELOG.md", released, next_version, date)
    print(f"{'Updated' if changed else 'Already at'} {next_version} (released {released})")


if __name__ == "__main__":
    main(sys.argv)
