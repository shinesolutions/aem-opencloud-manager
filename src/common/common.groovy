#!/usr/bin/env groovy
// src/common/common.groovy
package common

/**
 * Downloads a resource (usually an artifact) from a URL, then saves it on
 * destination directory with the given file name.
 * TODO: This download currently uses wget, but prolly best to replace it with
 * curl due to availability.
 */
def httpDownload(script, url, destDir, fileName) {
  script.sh """
  wget ${url} -O ${destDir}/${fileName}
  """
}
