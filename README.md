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

3. Create folder in Jenkins console named `aem-opencloud`.

4. Configure all jobs in the folder to use the shared library. The name of the library should be `aem`, default version is `master`, and the retrival method should use Modern SCM, git, with link: https://github.com/shinesolutions/aem-opencloud-manager

5. Login to AWS, create a temp user and grant S3 access to it, get the credentials and put them into Jenkins Credentials, the id of the credential should be `aem`.

6. Create a job named `mirror-artefacts` in the folder, use Jenkinsfile: `Jenkinsfile.mirror-artefacts`.

7. Create a job named `create-consolidated-aem` in folder `aem-opencloud`, use Jenkinsfile: `Jenkinsfile.create-consolidated-aem`.
