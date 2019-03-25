Configuration
-------------

The following configurations are available for users to customise:

| Name | Description | Required? | Default |
|------|-------------|-----------|---------|
| aws.library.s3_bucket | S3 Bucket to upload/download AEM OpenCloud libraries to/from | Mandatory | |
| aws.library.s3_path | S3 Path to the location of the AEM OpenCloud library artifacts | Optional | `library` |
| aem_opencloud.version | AEM OpenCloud version value to be displayed on Jenkins folder with format `aem-opencloud-<version>` | Optional | The current AEM OpenCloud version |
| aem_opencloud.config.artifact_url | URL to the location of the AEM OpenCloud configuration artifact | Mandatory | |
| aem_opencloud.custom_manager_steps.artifact_url | URL to the location of the AEM OpenCloud [Custom Manager Steps](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/customisation-points.md#custom-manager-steps) artifact | Mandatory | |
| aem_opencloud.custom_image_provisioner.artifact_url | URL to the location of the AEM OpenCloud [Custom Image Provisioner](https://github.com/shinesolutions/packer-aem/blob/master/docs/customisation-points.md#custom-image-provisioner) artifact | Mandatory | |
| aem_opencloud.custom_stack_provisioner.artifact_url | URL to the location of the AEM OpenCloud [Custom Stack Provisioner](https://github.com/shinesolutions/aem-aws-stack-builder/blob/master/docs/customisation-points.md#custom-stack-provisioner) artifact | Mandatory | |
| aem_opencloud.descriptors.\[consolidated\|full-set\].deployment_descriptor_url | URL to the location of [Deployment Descriptor](https://github.com/shinesolutions/aem-aws-stack-builder/blob/master/docs/descriptors.md#deployment-descriptor) file | Optional | |
| aem_opencloud.descriptors.\[consolidated\|full-set\].export_descriptor_url | URL to the location of [Package Backup Descriptor](https://github.com/shinesolutions/aem-aws-stack-builder/blob/master/docs/descriptors.md#package-backup-descriptor) file | Optional | |
| aem_opencloud.descriptors.\[consolidated\|full-set\].content_healthcheck_descriptor_url | URL to the location of [Content Health Check Descriptor](https://github.com/shinesolutions/aem-aws-stack-builder/blob/master/docs/descriptors.md#content-health-check-descriptor) file | Optional | |
| aem_opencloud.jenkins_sharedlibs.repo_url | URL to the [Jenkins shared libraries](https://jenkins.io/doc/book/pipeline/shared-libraries/) repository | Mandatory | |
| aem_opencloud.jenkins_sharedlibs.repo_branch | Branch name of the Jenkins shared libraries to be used | Optional | `master` |
| jenkins.protocol | Either `http` or `https`. | Optional | `http` |
| jenkins.host | FQDN of the Jenkins server | Optional | `localhost` |
| jenkins.port | Port of the Jenkins server | Optional | `8080` |
| jenkins.username | Jenkins username to create jobs. | Mandatory | |
| jenkins.password | Jenkins user password. | Mandatory | |
| jenkins.agent.docker_image | Jenkins Docker agent image to use | Optional | `shinesolutions/aem-platform-buildenv:latest` |
| jenkins.agent.docker_args | Additional Jenkins Docker agent CLI launch arguments | Optional | |
