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

Usage
-----

- Create [configuration file](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/configuration.md)
- Generate and provision the pipelines onto a Jenkins instance, for example: `make jenkins-aws config_path=stage/user-config/sandpit/`
