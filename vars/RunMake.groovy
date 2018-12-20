#!/usr/bin/env groovy

def call(script, repo_name, command) {
  script.sh """
    cd /opt/shinesolutions/${repo_name}
    eval ${command}
  """
}
