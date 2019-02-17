#!/usr/bin/env groovy
import common.*

def call(script, String downloadUrl, String tmpDir = '/tmp') {
  filename = "aem-opencloud-config.tar.gz"
  aoc_config_dir = "${tmpDir}/aem-opencloud-config"
  script.sh """
  mkdir -p ${tmpDir}/
  """
  new common().httpDownload(script, downloadUrl, tmpDir, filename)
  script.sh """
  mkdir -p ${aoc_config_dir}/
  tar --strip-components=1 -xzf ${tmpDir}/${filename} -C ${aoc_config_dir}/
  """
}
