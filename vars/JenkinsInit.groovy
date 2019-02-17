#!/usr/bin/env groovy

/**
 * This script is called at the beginning of all Jenkins pipelines, before
 * executing any steps, including custom manager steps' pipeline pre-step.
 * This could be handy in the future if AEM OpenCloud Manager has to execute
 * a custom command which Docker build agent can't include.
 */
def call(script) {
  script.sh """
    echo 'Initialising Jenkins environment...'
  """
}
