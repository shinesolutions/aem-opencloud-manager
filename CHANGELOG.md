# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Add jenkins-init target for Jenkins plugins provisioning

### Changed
- Upgrade Packer AEM to 4.5.0

## [4.0.0] - 2019-05-29

### Changed
- Improved aem upgrade export/import pipeline
- Upgrade Packer AEM to 4.4.1
- Upgrade AEM AWS Stack Builder to 4.3.0
- Upgrade AEM Stack Manager Messenger to 2.3.1
- Upgrade AEM Test Suite to 1.2.0
- Upgrade default Jenkins agent Docker image to aem-platform-buildenv 0.11.0

## [4.0.0-pre.2] - 2019-05-10

### Added
- Add upgrade pipeline for export/import

### Changed
- Upgrade Packer AEM to 4.2.0
- Updgrade aem-aws-stack-builder to 4.2.0

### Fixed
- Fix issue with create-full-set when providing a SOURCE_SNAPSHOT_STACK_PREFIX #25

## [4.0.0-pre.1] - 2019-04-09

### Added
- Initial version
- Add upgrade pipeline for in-place upgrade
