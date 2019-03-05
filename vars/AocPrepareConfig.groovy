#!/usr/bin/env groovy
import common.*
import cloud.aws

/**
 * This script downloads AEM OpenCloud configuration artifact from a URL and
 * unpacks it on temp directory, to be referenced as config_path by other
 * AEM OpenCloud libraries (e.g. Packer AEM, AEM AWS Stack Builder).
 */
def call(script, String aocConfigDownloadUrl, String tmpDir = '/tmp') {

  if (!aocConfigDownloadUrl) {
    println "Skipping AEM OpenCloud configuration download due to unspecified URL..."
    return
  }

  fileName = "aem-opencloud-config.tar.gz"
  aocConfigDir = "${tmpDir}/aem-opencloud-config/"
  script.sh """
  mkdir -p ${tmpDir}
  """

  def parsedUri = new URI(aocConfigDownloadUrl)
  switch (parsedUri.scheme) {
    case "http":
      new common().httpDownload(script, aocConfigDownloadUrl, tmpDir, fileName)
      break
    case "https":
      new common().httpDownload(script, aocConfigDownloadUrl, tmpDir, fileName)
      break
    case "s3":
      def bucket = parsedUri.host
      def path = parsedUri.path.split('/').init().drop(1).join('/')
      def object = parsedUri.path.split('/').last()
      new aws().s3_download(script, bucket, path, object, tmpDir, fileName)
      break
    default:
      println "Unsupported AEM OpenCloud configuration download URL: " + aocConfigDownloadUrl
      break
  }

  script.sh """
  mkdir -p ${aocConfigDir}/
  tar --strip-components=1 -xzf ${tmpDir}/${fileName} -C ${aocConfigDir}/
  """
}
