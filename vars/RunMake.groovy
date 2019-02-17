#!/usr/bin/env groovy

/**
 * This script executes a command for a specified AEM OpenCloud library path.
 * This is typically a `make` command which is a common build target interface
 * for AEM OpenCloud libraries.
 */
def call(script, libraryDir, library, command) {
  script.sh """
    cd ${libraryDir}/${library}/
    eval ${command}
  """
}
