# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Unreleased

### Added
- Add new Jenkins Job category `utilities` for general utility jobs
- Add utility pipeline `encrypt-snapshots` for encrypting OpenCloud Snapshots on AWS
- Added installation integration test for rhel7 aem65

### Changed
- Upgrade AEM AWS Stack Builder to 4.34.0
- Upgrade default Jenkins agent Docker image to aem-platform-buildenv 1.6.0
- Upgrade AEM Test Suite to 1.15.0
- Upgrade AEM Stack Manager Messenger to 2.11.0

### Fixed
- Fix Jenkins Shared Libraries' Git path

## 4.3.0 - 2020-02-11
### Changed
- Upgrade Packer AEM to 4.22.0
- Upgrade AEM AWS Stack Builder to 4.33.0

## 4.2.1 - 2020-02-06
### Changed
- Upgrade AEM AWS Stack Builder to 4.32.0

### Fixed
- Fix aggressive CPU high alarm by increasing threshold to 60 (warning) and 90 (critical)

## 4.2.0 - 2020-02-03
### Added
- Added new build parameter REMOVE_PREREQUISITES to disable removal of the AEM Stack prerequisites for delete Full-Set and Consolidated [#58]
- Added aem65 to machine images integration testing

### Changed
- Upgrade Packer AEM to 4.20.0
- Upgrade AEM AWS Stack Builder to 4.30.0

## 4.2.0-pre.2 - 2010-01-21
### Changed
- Upgrade Packer AEM to 4.20.0
- Upgrade AEM AWS Stack Builder to 4.30.0
- Upgrade AEM Stack Manager Messenger to 2.10.0
- Upgrade AEM Test Suite to 1.13.0
- Upgrade default Jenkins agent Docker image to aem-platform-buildenv 1.3.0

## 4.2.0-pre.1 - 2019-12-04
### Changed
- Upgrade Packer AEM to 4.16.0
- Upgrade AEM AWS Stack Builder to 4.24.0
- Upgrade AEM Stack Manager Messenger to 2.9.0
- Upgrade AEM Test Suite to 1.7.0

### Fixed
- Fix generation of offline snapshot yaml file if destination dir does not exists [#60]

## 4.2.0-pre.0 - 2019-10-20
### Changed
- Upgrade Packer AEM to 4.15.0
- Upgrade AEM AWS Stack Builder to 4.23.2

## 4.1.0-pre.8 - 2019-10-15
### Added
- Add Switch-DNS function to Jenkins environment parameter
- Add cloudwatch:PutDashboard and cloudwatch:DeleteDashboards permissions for AemAwsStackBuilderRolePolicy and OpenCloudUnifiedRolePolicy

### Changed
- Upgrade Packer AEM to 4.13.0
- Upgrade AEM AWS Stack Builder to 4.21.0
- Upgrade AEM Stack Manager Messenger to 2.8.0

## 4.1.0-pre.7 - 2019-09-24
### Added
- Add OpenCloudUnifiedRole IAM role with unified permissions to aws-resources
- Added parameter to AEM In-Place upgrade to skip repository migration
- Add new configuration parameter to enable/disable SLACK notifications

### Changed
- Upgrade Packer AEM to 4.12.0
- Upgrade AEM AWS Stack Builder to 4.17.0
- Rename make target jenkins-aws-user-resources to jenkins-aws-resources
- Move stack_prefix from user config to make target arg for jenkins-aws-resources
- Replace user_resources.aws.vpc_id with aws.vpc_id configuration
- Change Slack failure message prefix from FAIL to FAILURE

## 4.1.0-pre.6 - 2019-09-08
### Added
- Add Slack notification in the pipeline

### Changed
- Update operational task `test-security` to prepare configuration for aem-test-suite
- Upgrade AEM Test Suite to 1.5.0
- Upgrade AEM AWS Stack Builder to 4.11.0

## 4.1.0-pre.5 - 2019-08-23
### Changed
- Upgrade AEM AWS Stack Builder to 4.9.0
- Upgrade AEM Test Suite to 1.6.0

### Fixed
- Fix missing content-healthcheck descriptor on blue-green testing's green env creation
- Fix path to Jenkinsfile for the operational tasks using aem-test-suite

## 4.1.0-pre.4 - 2019-08-19
### Changed
- Upgrade Packer AEM to 4.10.0
- Upgrade AEM AWS Stack Builder to 4.8.0
- Upgrade AEM Stack Manager Messenger to 2.7.0
- Upgrade AEM Test Suite to 1.4.0
- Upgrade default Jenkins agent Docker image to aem-platform-buildenv 1.1.0

### Fixed
- Fixed error in generating operational test tasks

## 4.1.0-pre.3 - 2019-08-06
### Added
- Add feature to manage SAML
- Add permissions for deleting AWS CloudFormation stacks

### Changed
- Upgrade default Jenkins agent Docker image to aem-platform-buildenv 1.0.0
- Upgrade Packer AEM to 4.8.0
- Upgrade AEM AWS Stack Builder to 4.7.0
- Upgrade AEM Stack Manager Messenger to 2.6.0
- Rename jenkins-provision-aws-user-resources to jenkins-aws-user-resources for consistency
- Renamed testing operational tasks

### Removed
- Removed operational task `export-package` due to bugs

### Fixed
- Fixed several bugs in Jenkins testing pipelines

## 4.1.0-pre.2 - 2019-07-24
### Added
- Add jenkins-init target for Jenkins plugins provisioning

### Changed
- Upgrade Packer AEM to 4.7.0
- Upgrade AEM AWS Stack Builder to 4.6.0
- Upgrade AEM Stack Manager Messenger to 2.4.0
- Upgrade AEM Test Suite to 1.3.0

## 4.0.0 - 2019-05-29
### Changed
- Improved aem upgrade export/import pipeline
- Upgrade Packer AEM to 4.4.1
- Upgrade AEM AWS Stack Builder to 4.3.0
- Upgrade AEM Stack Manager Messenger to 2.3.1
- Upgrade AEM Test Suite to 1.2.0
- Upgrade default Jenkins agent Docker image to aem-platform-buildenv 0.11.0

## 4.0.0-pre.2 - 2019-05-10
### Added
- Add upgrade pipeline for export/import

### Changed
- Upgrade Packer AEM to 4.2.0
- Updgrade aem-aws-stack-builder to 4.2.0

### Fixed
- Fix issue with create-full-set when providing a SOURCE_SNAPSHOT_STACK_PREFIX [#25]

## 4.0.0-pre.1 - 2019-04-09
### Added
- Initial version
- Add upgrade pipeline for in-place upgrade
