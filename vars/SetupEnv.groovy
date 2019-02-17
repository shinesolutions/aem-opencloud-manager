#!/usr/bin/env groovy

def call(script) {
  script.sh """
    echo 'Setting up environment for executing AEM OpenCloud Jenkins job...'
  """
}
