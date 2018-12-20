#!/usr/bin/env groovy

def call(script, String s3Endpoint = 's3://aem-opencloud/library-kai', String repo, String version) {
  filename = "${repo}-${version}.tar.gz"
  script.sh """
  mkdir -p /opt/shinesolutions/${repo}/
  aws s3 cp s3://${s3Endpoint}/${filename} /tmp/${filename} && \
  tar -xzf /tmp/${filename} -C /opt/shinesolutions/${repo}/
  """
}
