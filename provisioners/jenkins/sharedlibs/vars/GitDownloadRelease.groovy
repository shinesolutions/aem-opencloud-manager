#!/usr/bin/env groovy
import common.*

def call(script, String user, String repo, String version, String tmpDir = '/tmp') {
  archive_url = "https://github.com/${user}/${repo}/releases/download/${version}/${repo}-${version}.tar.gz"
  filename = "${repo}-${version}.tar.gz"
  script.sh """
  mkdir -p ${tmpDir}
  """
  new common().httpDownload(script, archive_url, tmpDir, filename)
}
