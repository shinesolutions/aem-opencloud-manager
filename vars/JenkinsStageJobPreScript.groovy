#!/usr/bin/env groovy

def call(script) {
  // Call Jenkins Job Stage pre-script
  script.sh """
  if [ -e /tmp/shinesolutions/jenkins/stage-pre-common.sh ]
  then
     echo "Executing Stage pre-script"
     /tmp/shinesolutions/jenkins/stage-pre-common.sh
  else
    echo "Stage pre-script not found. Skipping..."
  fi
  """
}
