#!/usr/bin/env groovy

/**
 * This script executes the pipeline-pre-common.sh script contained within
 * custom Jenkins provisioner package.
 */
def call(script) {
  script.sh """
  if [ -x /tmp/shinesolutions/custom-manager-provisioner/pipeline-pre-common.sh ]
  then
     echo "Executing pipeline pre-step script of custom Jenkins shared libraries..."
     /tmp/shinesolutions/custom-manager-provisioner/pipeline-pre-common.sh
  else
    echo "Jenkins pipeline pre-step script is either not provided or not executable"
  fi
  """
}
