#!/usr/bin/env groovy
import common.*
import cloud.aws

/**
 * This script downloads a parameter artifact from a URL defined by user and
 * copies it to a destination directory, to be consumed by AEM OpenCloud
 * libraries (e.g. Packer AEM, AEM AWS Stack Builder).
 */
def call(script, String paramArtifactDownloadUrl, String destDir, String destFile) {

  if (!paramArtifactDownloadUrl) {
    println "Skipping parameter artifact download due to unspecified URL..."
    return
  } else {
    println "Using parameter artifact download URL " + paramArtifactDownloadUrl
  }

  script.sh """
  mkdir -p ${destDir}/
  """

  def parsedUri = new URI(paramArtifactDownloadUrl)
  switch (parsedUri.scheme) {
    case "http":
      new common().httpDownload(script, paramArtifactDownloadUrl, destDir, destFile)
      break
    case "https":
      new common().httpDownload(script, paramArtifactDownloadUrl, destDir, destFile)
      break
    case "s3":
      def bucket = parsedUri.host
      def path = parsedUri.path.split('/').init().drop(1).join('/')
      def object = parsedUri.path.split('/').last()
      new aws().s3_download(script, bucket, path, object, destDir, destFile)
      break
    default:
      println "Unsupported param artifact download URL: " + paramArtifactDownloadUrl
      break
  }
}
