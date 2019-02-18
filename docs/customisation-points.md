Customisation Points
--------------------

Since every user has a unique standard operating environment and security requirements, AEM OpenCloud Manager provides two customisation points where user can provision any specific setup.

### Configuration

You can set up a number of [configuration properties](https://github.com/shinesolutions/aem-opencloud-manager/blob/master/docs/configuration.md) to suit your requirements.
Have a look at the [user config examples](https://github.com/shinesolutions/aem-helloworld-config/tree/master/aem-opencloud-manager/) for reference on what configuration values you need to set.

This allows you to create a number of configuration profiles. For example, if you need to provision multiple Jenkins instances, e.g. one CI/CD environment in prod and several CI/CD environments in non-prod.

### Custom Manager Steps

For user-specific steps, they can be defined in a Custom Manager Steps package, which provides pipeline pre-step, pipeline post-step, stage pre-step, and stage post-step.

For example, if you need to authenticate to retrieve an STS token or perhaps you need to access an external authentication service first before executing the build steps, then you can have that implemented on either the pipeline pre-step or stage pre-step.

In order to use Custom Manager Steps, you need to:

* Set the configuration property `aem_opencloud.custom_manager_steps.artifact_url` to the URL where custom manager steps package can be downloaded from.

To get an idea how this artifact should be structured, please have a look at the example repository [AEM Hello World Custom Manager Steps](https://github.com/shinesolutions/aem-helloworld-custom-manager-steps).
