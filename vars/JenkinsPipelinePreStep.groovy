#!/usr/bin/env groovy

def call(script) {
  // Call Jenkins Job Global pre-script
  script.sh """
  if [ -e /tmp/shinesolutions/aem-opencloud-manager/global-pre-common.sh ]
  then
     echo "Calling global pre-script"
     /tmp/shinesolutions/aem-opencloud-manager/global-pre-common.sh
  else
    echo "Global pre-script not found. Skipping..."
  fi
  """
}
