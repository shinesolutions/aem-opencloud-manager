#!/usr/bin/env groovy

/**
 * This script executes the stage-pre-common.sh script contained within
 * custom Jenkins provisioner package.
 */
def call(script) {
  script.sh """
  if [ -x /tmp/shinesolutions/custom-manager-provisioner/stage-pre-common.sh ]
  then
     echo "Executing stage pre-step script of custom Jenkins shared libraries..."
     /tmp/shinesolutions/custom-manager-provisioner/stage-pre-common.sh
  else
    echo "Jenkins stage pre-step script is either not provided or not executable"
  fi
  """
}
