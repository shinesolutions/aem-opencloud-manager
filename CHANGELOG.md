# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Unreleased
### Added
- Add Switch-DNS function to Jenkins environment parameter 

### Added
- Add cloudwatch:PutDashboard and cloudwatch:DeleteDashboards permissions for AemAwsStackBuilderRolePolicy and OpenCloudUnifiedRolePolicy

## [4.1.0-pre.7] - 2019-09-24

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

## [4.1.0-pre.6] - 2019-09-08
### Added
- Add Slack notification in the pipeline

### Changed
- Update operational task `test-security` to prepare configuration for aem-test-suite
- Upgrade AEM Test Suite to 1.5.0
- Upgrade AEM AWS Stack Builder to 4.11.0

## [4.1.0-pre.5] - 2019-08-23

### Changed
- Upgrade AEM AWS Stack Builder to 4.9.0
- Upgrade AEM Test Suite to 1.6.0

### Fixed
- Fix missing content-healthcheck descriptor on blue-green testing's green env creation
- Fix path to Jenkinsfile for the operational tasks using aem-test-suite

## [4.1.0-pre.4] - 2019-08-19

### Changed
- Upgrade Packer AEM to 4.10.0
- Upgrade AEM AWS Stack Builder to 4.8.0
- Upgrade AEM Stack Manager Messenger to 2.7.0
- Upgrade AEM Test Suite to 1.4.0
- Upgrade default Jenkins agent Docker image to aem-platform-buildenv 1.1.0

### Fixed
- Fixed error in generating operational test tasks

## [4.1.0-pre.3] - 2019-08-06

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

### Fixed
- Fixed several bugs in Jenkins testing pipelines

### Removed
- Removed operational task `export-package` due to bugs

## [4.1.0-pre.2] - 2019-07-24

### Added
- Add jenkins-init target for Jenkins plugins provisioning

### Changed
- Upgrade Packer AEM to 4.7.0
- Upgrade AEM AWS Stack Builder to 4.6.0
- Upgrade AEM Stack Manager Messenger to 2.4.0
- Upgrade AEM Test Suite to 1.3.0

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
