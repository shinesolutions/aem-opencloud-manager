#!/usr/bin/env groovy
import common.*
import cloud.aws

/**
 * This script mirrors an AEM OpenCloud library by downloading the artifact from
 * GitHub and then stores it on S3.
 */
def call(script, String user, String repo, String version, String s3Bucket, s3Path, String tmpDir = '/tmp') {
  libraryUrl = "https://github.com/${user}/${repo}/releases/download/${version}/${repo}-${version}.tar.gz"
  if(version == "master"  || version == "latest" )
  {
      libraryUrl = "https://github.com/${user}/${repo}/archive/master.tar.gz"
  }
  println "Hellooo"
  script.sh """
  mkdir -p ${tmpDir}
  """
  new common().httpDownload(script, libraryUrl, tmpDir, "${repo}-${version}.tar.gz")
  new aws().s3_upload(script, tmpDir, "${repo}-${version}.tar.gz", s3Bucket, s3Path)
}
