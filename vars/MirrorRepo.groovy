#!/usr/bin/env groovy

def call(script, String s3Endpoint = 's3://aem-opencloud/library-kai', String repo, String version) {
  archive_url = "https://github.com/shinesolutions/${repo}/releases/download/${version}/${repo}-${version}.tar.gz"
  filename = "${repo}-${version}.tar.gz"
  script.sh """
  wget ${archive_url} -O /tmp/${filename} \
  && aws s3 cp /tmp/${filename} s3://${s3Endpoint}/${filename}
  """
}
