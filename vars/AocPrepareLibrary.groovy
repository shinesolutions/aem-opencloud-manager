#!/usr/bin/env groovy
import cloud.aws

/**
 * This script downloads mirrored AEM OpenCloud library from S3 and saves it
 * on temp directory.
 */
def call(script, String artifact, String version, String s3Bucket, String s3Path, String tmpDir) {
  new aws().s3_download(script, s3Bucket, s3Path, "${artifact}-${version}.tar.gz", destDir)
  script.sh """
  mkdir -p ${tmpDir}/${artifact}/
  tar -xzf ${tmpDir}/${artifact}-${version}.tar.gz -C ${tmpDir}/${artifact}/
  """
}
