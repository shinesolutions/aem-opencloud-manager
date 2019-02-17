#!/usr/bin/env groovy
import common.*

/**
 * This script downloads AEM OpenCloud configuration artifact and unpacks it
 * on temp directory, to be referenced as config_path by other AEM OpenCloud
 * libraries (e.g. Packer AEM, AEM AWS Stack Builder).
 */
def call(script, String downloadUrl, String tmpDir = '/tmp') {
  fileName = "aem-opencloud-config.tar.gz"
  aocConfigDir = "${tmpDir}/aem-opencloud-config/"
  script.sh """
  mkdir -p ${tmpDir}/
  """
  new common().httpDownload(script, downloadUrl, tmpDir, fileName)
  script.sh """
  mkdir -p ${aocConfigDir}/
  tar --strip-components=1 -xzf ${tmpDir}/${fileName} -C ${aocConfigDir}/
  """
}
