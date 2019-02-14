#!/usr/bin/env groovy
import cloud.aws

def call(script, String repo, String version, String s3Endpoint, String destDir) {
  filename = "${repo}-${version}.tar.gz"
  new aws().s3_download(script, s3Endpoint, filename, destDir)
}
