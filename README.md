# About

This repo provides sample Jenkinsfiles and a Jenkins shared library that can be used to run CI tests for the AEM OpenCloud config files.

# Warning

This is a work-in-progress. You are more than welcome to follow the progress of this repo, but it is not of production quality yet. All APIs are subject to change without notice.

# Usage

0. Prerequisites:

  - docker
  - network connection to install plugins

1. Build Jenkins image with `make build`. This will Jenkins in a container with plugins pre-installed and settings pre-configured.

2. Run Jenkins with `make run`. Please create a user and login now.

3. Open a browser and login to your Jenkins instance http://localhost:8080 and setup at least a user

4. Setup own configuration file see examples/user-config/config.yaml

5. Run `make manager-data config_path=examples/user-config/config.yaml` to create all files to configure Jenkins.
(You need to adjust config_path to your own need.)

6. Run `make installation config_path=examples/user-config/config.yaml` to create all Jenkins jobs automated.
(You need to adjust config_path to your own need.)


# Pre/Post Hooks

Pre and Post hooks are getting executed once globally before and after the pipeline job and every stage.
Hooks are getting called as Shell script and at the shell script needs to be copied manually to the right location.

## Global Pre/Post Hook
Global hooks are getting executed once at the beginning and at the end of the pipelin

## Stage Pre/Post Hook
Stage hooks are getting execute before and after every the stage.

| Location        | Description |
| ------------- |:-------------:|
| /tmp/shinesolutions/aem-opencloud-manager/global-pre-common.sh     | Global Pre-script. Runs once at the beginning of the Pipeline. |
| /tmp/shinesolutions/aem-opencloud-manager/global-post-common.sh    | Global Post-script. Runs once at the end of the Pipeline. |
| /tmp/shinesolutions/aem-opencloud-manager/stage-pre-common.sh      | Stage Pre-Script. Runs every time at the beginning of a stage. |
| /tmp/shinesolutions/aem-opencloud-manager/stage-post-common.sh     | Stage Post-Script. Runs every time at the end of a stage. |
