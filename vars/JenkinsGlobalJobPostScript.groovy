#!/usr/bin/env groovy

def call(script) {
  // Call Jenkins Job Global post-script
  script.sh """
  if [ -e /tmp/shinesolutions/aem-opencloud-manager/global-post-common.sh ]
  then
     echo "Calling global post-script"
     /tmp/shinesolutions/aem-opencloud-manager/global-post-common.sh
  else
    echo "Global post-script not found. Skipping..."
  fi
  """
}
