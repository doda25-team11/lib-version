# Here lie the versioning workflows for F2 and F11 of the 1st assignment.

The `release.yaml` workflow is repsonsible for stable releases. First, it removes the `SNAPSHOT` fragment from pom.xml. Then it deploys the release as a stable version to Github Packages, if pushed to main. Afterwards, it bumps the patch in POM using `mvn::versions`, and pushes the changes.

The `prerelease.yaml` workflow coordinates the versioning of prereleases, when the pushes are commenced not on the main branch. It formats the name to be: `{version}-{branch name}-{date}-{time}` and publishes it to the Github Packages.