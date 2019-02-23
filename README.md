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

Usage
-----

- Create [configuration file](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/configuration.md)
- Generate and provision the pipelines onto a Jenkins instance, for example: `make jenkins-aws config_path=stage/user-config/sandpit/`
- Visit your Jenkins instance and you should find a new folder named `aem-opencloud-<version>`

Build categories
----------------

| Category | Description |
|----------|-------------|
| installation | Installs AEM OpenCloud libraries () followed by the AEM AWS Stack Builder dependency libraries () |
| machine-images | |
| manage-environments | |
| manage-stacks | |
| operations | |
| testing | |

Testing
-------

### Testing with remote dependencies

You can run integration test for generating and provisioning Jenkins pipelines using the command `make test-integration cicd_type=jenkins platform_type=aws`, which downloads the dependencies from the Internet.

### Testing with local dependencies

If you're working on the dependencies of AEM OpenCloud Manager and would like to test them as part of pipelines generation and provisioning, you need to:

- Clone the dependency repos [AEM Hello World Config](https://github.com/shinesolutions/aem-helloworld-config) at the same directory level as AEM OpenCloud Manager
- Make your code changes against those dependency repos
- Run `make test-integration-local cicd_type=jenkins platform_type=aws` for integration testing using local dependencies, which copies those local dependency repos to AEM OpenCloud Manager and use them as part of the test
