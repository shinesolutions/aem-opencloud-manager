[![Build Status](https://img.shields.io/travis/shinesolutions/aem-opencloud-manager.svg)](http://travis-ci.org/shinesolutions/aem-opencloud-manager)

AEM OpenCloud Manager
---------------------

AEM OpenCloud Manager is a set of [Jenkins](https://jenkins.io/) pipelines for provisioning and managing AEM OpenCloud environments.

These pipelines can be provisioned to a CI/CD system (currently only supports Jenkins) and serves as

Learn more about AEM OpenCloud Manager:

* [Installation](https://github.com/shinesolutions/aem-opencloud-manager#installation)
* [Configuration](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/configuration.md)
* [Usage](https://github.com/shinesolutions/aem-opencloud-manager#usage)
* [Testing](https://github.com/shinesolutions/aem-opencloud-manager#testing)
* [AWS Permissions](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/aws-permissions.md)
* [Customisation Points](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/customisation-points.md)

AEM OpenCloud Manager is part of [AEM OpenCloud](https://aemopencloud.io) platform.

Installation
------------

- Either clone AEM OpenCloud Manager `git clone https://github.com/shinesolutions/aem-opencloud-manager.git` or download one of the [released versions](https://github.com/shinesolutions/aem-opencloud-manager/releases)
- Install the following required tools:
  * [Python](https://www.python.org/downloads/) version 2.7.x
  * [GNU Make](https://www.gnu.org/software/make/)<br/>

  Alternatively, you can use [AEM Platform BuildEnv](https://github.com/shinesolutions/aem-platform-buildenv) Docker container to run AEM OpenCloud Manager build targets.
- Resolve the [Python packages](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/requirements.txt) dependencies by running `make deps`
- Install the following plugins on your Jenkins instance:
  * [Pipeline Utility Steps plugin](https://plugins.jenkins.io/pipeline-utility-steps)
- Approve the following script signatures via Jenkins' `Manage Jenkins`->`In-process Script Approval` menu:
  * `method java.net.URI getHost`
  * `method java.net.URI getPath`
  * `method java.net.URI getScheme`
  * `new java.net.URI java.lang.String`
  * `staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods drop java.lang.Object[] int`
  * `staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods init java.lang.Object[]`

Usage
-----

- Set up the required [AWS Permissions](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/aws-permissions.md)
- Create [configuration file](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/configuration.md)
- Provision required plugins onto Jenkins instance: `make jenkins-init config_path=<path/to/config/dir>`
- Generate and provision the pipelines onto a Jenkins instance: `make jenkins-aws config_path=<path/to/config/dir>`
- Visit your Jenkins instance and you should find a new folder named `aem-opencloud-<version>`

Build categories
----------------

| Category | Description |
|----------|-------------|
| installation | Install AEM OpenCloud libraries ([Packer AEM](https://github.com/shinesolutions/packer-aem), [AEM AWS Stack Builder](https://github.com/shinesolutions/aem-aws-stack-builder), [AEM Stack Manager Messenger](https://github.com/shinesolutions/aem-stack-manager-messenger), [AEM Test Suite](https://github.com/shinesolutions/aem-test-suite)) followed by the AEM AWS Stack Builder dependency libraries. |
| machine-images | Create machine images containing AEM installations and utilities. |
| manage-environments | Create and delete AEM Stack Manager, AEM Consolidated, and AEM Full-Set environments. |
| operational-tasks | Run AEM operational tasks such as deploying AEM packages, taking backups, flushing cache, promoting AEM Author Standby to become Primary, and many others. |
| testing | Run various tests against AEM environments. |

Testing
-------

### Testing with remote dependencies

You can run integration test for generating and provisioning Jenkins pipelines using the command `make test-integration cicd_type=jenkins platform_type=aws`, which downloads the dependencies from the Internet.

### Testing with local dependencies

If you're working on the dependencies of AEM OpenCloud Manager and would like to test them as part of pipelines generation and provisioning, you need to:

- Clone the dependency repos [AEM Hello World Config](https://github.com/shinesolutions/aem-helloworld-config) at the same directory level as AEM OpenCloud Manager
- Make your code changes against those dependency repos
- Run `make test-integration-local cicd_type=jenkins platform_type=aws` for integration testing using local dependencies, which copies those local dependency repos to AEM OpenCloud Manager and use them as part of the test
