#!/usr/bin/env groovy
import cloud.aws

def call(script, String repo, String version, String s3Endpoint, String sourceDir) {
  filename = "${repo}-${version}.tar.gz"
  new aws().s3_upload(script, sourceDir, filename, s3Endpoint)
}
