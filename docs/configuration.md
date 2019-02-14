Configuration
-------------

The following configurations are available for users to customise:

| Name | Description | Required? | Default |
|------|-------------|-----------|---------|
| aws.library.s3_bucket | S3 Bucket to upload/download AEM OpenCloud libraries to/from | Mandatory | |
| aws.library.s3_path | S3 Path to the location of the AEM OpenCloud library artifacts | Optional | `library` |
| aem_opencloud.config.artifact_url | URL to the location of the AEM OpenCloud configuration artifact | Mandatory | |
| aem_opencloud.jenkins_sharedlibs.repo_url | URL to the [Jenkins shared libraries](https://jenkins.io/doc/book/pipeline/shared-libraries/) repository | Mandatory | |
| aem_opencloud.jenkins_sharedlibs.repo_branch | Branch name of the Jenkins shared libraries to be used | Optional | `master` |
| jenkins.protocol | Either `http` or `https`. | Optional | `http` |
| jenkins.host | FQDN of the Jenkins server | Optional | `localhost` |
| jenkins.port | Port of the Jenkins server | Optional | `8080` |
| jenkins.username | Jenkins username to create jobs. | Mandatory | |
| jenkins.password | Jenkins user password. | Mandatory | |
