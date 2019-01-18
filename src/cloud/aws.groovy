#!/usr/bin/env groovy
// src/cloud/aws.groovy
package cloud

def s3_download(script, s3Endpoint, filename, destDir) {
  script.sh """
  aws s3 cp s3://${s3Endpoint}/${filename} ${destDir}/${filename}
  """
}

def s3_upload(script, source_dir, filename, s3Endpoint) {
  script.sh """
  aws s3 cp ${source_dir}/${filename} s3://${s3Endpoint}/${filename}
  """
}
