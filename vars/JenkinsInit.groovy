#!/usr/bin/env groovy
import common.*
import cloud.aws

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
  def parsedUri = new URI(aocCustomManagerStepsDownloadUrl)
  switch (parsedUri.scheme) {
    case "http":
      new common().httpDownload(script, aocCustomManagerStepsDownloadUrl, tmpDir, fileName)
      break
    case "https":
      new common().httpDownload(script, aocCustomManagerStepsDownloadUrl, tmpDir, fileName)
      break
    case "s3":
      def bucket = parsedUri.host
      def path = parsedUri.path.split('/').init().drop(1).join('/')
      def object = parsedUri.path.split('/').last()
      new aws().s3_download(script, bucket, path, object, tmpDir, fileName)
      break
    default:
      println "Unsupported protocol for download URL: " + aocCustomManagerStepsDownloadUrl
      break
  }

  script.sh """
  mkdir -p ${aocCustomManagerStepsDir}/
  tar --strip-components=1 -xzf ${tmpDir}/${fileName} -C ${aocCustomManagerStepsDir}/
  """
}
