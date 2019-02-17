#!/usr/bin/env groovy
import common.*

/**
 * This script downloads AEM OpenCloud custom manager steps from a URL and
 * unpacks it on temp directory. Its pre and post steps would be executed by
 * all Jenkins pipelines accordingly.
 */
def call(script, String aocCustomManagerStepsDownloadUrl, String tmpDir = '/tmp') {
  fileName = "custom-manager-steps.tar.gz"
  aocCustomManagerStepsDir = "${tmpDir}/custom-manager-steps/"
  script.sh """
  echo 'Initialising Jenkins environment...'
  mkdir -p ${tmpDir}/
  """
  new common().httpDownload(script, aocCustomManagerStepsDownloadUrl, tmpDir, fileName)
  script.sh """
  mkdir -p ${aocCustomManagerStepsDir}/
  tar --strip-components=1 -xzf ${tmpDir}/${fileName} -C ${aocCustomManagerStepsDir}/
  """
}
