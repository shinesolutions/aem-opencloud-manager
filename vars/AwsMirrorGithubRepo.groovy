#!/usr/bin/env groovy
import common.*
import cloud.aws

def call(script, String user, String repo, String version, String s3Endpoint, String tmpDir = '/tmp') {
  GithubDownloadRelease(script, user, repo, version, tmpDir)
  AwsS3Upload(script, repo, version, s3Endpoint, tmpDir)
}
