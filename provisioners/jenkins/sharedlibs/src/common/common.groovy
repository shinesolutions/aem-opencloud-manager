#!/usr/bin/env groovy
// src/common/common.groovy
package common

def httpDownload(script, url, dest_dir, filename) {
  script.sh """
  wget ${url} -O ${dest_dir}/${filename}
  """
}
