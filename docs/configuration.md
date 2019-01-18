Configuration
-------------

The following configurations are available for users.

### Configuration properties:

| Name | Description | Required? | Default |
|------|-------------|-----------|---------|
| aws.s3_library_bucket | S3 Bucket to upload/download AEM OpenCloud libraries. | Required | `aem-opencloud` |
| aws.s3_library_path | S3 Path to the location of the AEM OpenCloud libraries.. | Required | `jenkins/library` |
| jenkins.url | FQDN of the Jenkins server | Required | `localhost` |
| jenkins.port | Port of the Jenkins server | Required | `8080` |
| jenkins.username | Jenkins username to create jobs. | Required | `jadmin` |
| jenkins.password | Jenkins user password. | Required | `jadmin` |
| opencloud.config_archive_url | URL to the location of the OpenCloud configuration archive | Optional | `https://github.com/shinesolutions/aem-helloworld-config/archive/master.tar.gz` |
| opencloud.manager.repo_url | URL to the AEM OpenCloud Manager repository | Optional | `https://github.com/shinesolutions/aem-opencloud-manager` |
| opencloud.manager.branch | Branch name of the AEM OpenCloud Manager repository | Optional | `master` |
