Customisation Points
--------------------

Since every user has a unique standard operating environment and security requirements, AEM OpenCloud Manager provides three customisation points where user can provision any specific setup.

### Configuration

You can set up a number of [configuration properties](https://github.com/shinesolutions/aem-opencloud-manager/blob/main/docs/configuration.md) to suit your requirements.
Have a look at the [user config examples](https://github.com/shinesolutions/aem-helloworld-config/tree/main/aem-opencloud-manager/) for reference on what configuration values you need to set.

This allows you to create a number of configuration profiles. For example, if you need to provision multiple Jenkins instances, e.g. one CI/CD environment in prod and several CI/CD environments in non-prod.

### Build agent

The Jenkins pipelines can be configured to run on your own Docker container, you need to:

* Set the Docker image on `jenkins.agent.docker_image` configuration property

As long as the Jenkins master host already has the configured Docker image, the pipeline will then start a container for each build, allowing you to control what should be provisioned on the build agent. For example, if you need to authenticate using a particular library, then this library needs to be provisioned on your Docker image.

If you don't configure the Docker image, by default AEM OpenCloud Manager will use `[shinesolutions/aem-platform-buildenv:<version>](https://hub.docker.com/r/shinesolutions/aem-platform-buildenv/)` public Docker image.

### Custom Manager Steps

For user-specific steps, they can be defined in a Custom Manager Steps package, which provides pipeline pre-step, pipeline post-step, stage pre-step, stage post-step, exec pre-step, exec post-step.

For example, if you need to authenticate to retrieve an STS token or perhaps you need to access an external authentication service first before executing the build steps, then you can have that implemented on either the pipeline pre-step or stage pre-step.

In order to use Custom Manager Steps, you need to:

* Set the configuration property `aem_opencloud.custom_manager_steps.artifact_url` to the URL where custom manager steps package can be downloaded from.

To get an idea how this artifact should be structured, please have a look at the example repository [AEM Hello World Custom Manager Steps](https://github.com/shinesolutions/aem-helloworld-custom-manager-steps).
