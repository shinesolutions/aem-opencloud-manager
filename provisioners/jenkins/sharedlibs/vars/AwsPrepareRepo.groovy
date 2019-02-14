#!/usr/bin/env groovy

def call(script, String repo, String version, String s3Endpoint, String tmpDir) {
  filename = "${repo}-${version}.tar.gz"
  AwsS3Download(script, repo, version, s3Endpoint, tmpDir)
  script.sh """
  mkdir -p ${tmpDir}/${repo}/
  tar -xzf ${tmpDir}/${filename} -C ${tmpDir}/${repo}/
  """
}
