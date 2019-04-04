#!/usr/bin/env groovy

/**
 * This script executes a command for a specified AEM OpenCloud library path.
 * This is typically a `make` command which is a common build target interface
 * for AEM OpenCloud libraries.
 */
def call(script, libraryDir, library, command) {
  script.sh """

    if [ -x /tmp/shinesolutions/aem-opencloud-manager/custom-manager-steps/exec-pre-common.sh ]
    then
       echo "Executing exec pre-step script of Custom Manager Steps..."
       AOC_LIBRARY="${library}" \
         AOC_COMMAND="${command}" \
         /tmp/shinesolutions/aem-opencloud-manager/custom-manager-steps/exec-pre-common.sh
    else
      echo "Jenkins exec pre-step script is either not provided or not executable"
    fi

    cd ${libraryDir}/${library}/
    eval ${command}

    if [ -x /tmp/shinesolutions/aem-opencloud-manager/custom-manager-steps/exec-post-common.sh ]
    then
       echo "Executing exec post-step script of Custom Manager Steps..."
       AOC_LIBRARY="${library}" \
         AOC_COMMAND="${command}" \
         /tmp/shinesolutions/aem-opencloud-manager/custom-manager-steps/exec-post-common.sh
    else
      echo "Jenkins exec post-step script is either not provided or not executable"
    fi

  """
}
