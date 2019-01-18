#!/usr/bin/env groovy

def call(script, repoRootDir, repoName, command) {
  script.sh """
    cd ${repoRootDir}/${repoName}
    eval ${command}
  """
}
