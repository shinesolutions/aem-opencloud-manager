#!/usr/bin/env groovy

/**
 * This script executes the stage-post-common.sh script contained within
 * custom Jenkins provisioner package.
 */
def call(script) {
  script.sh """
  if [ -x /tmp/shinesolutions/aem-opencloud-manager/custom-manager-steps/stage-post-common.sh ]
  then
     echo "Executing stage post-step script of custom Jenkins shared libraries..."
     /tmp/shinesolutions/aem-opencloud-manager/custom-manager-steps/stage-post-common.sh
  else
    echo "Jenkins stage post-step script is either not provided or not executable"
  fi
  """
}
