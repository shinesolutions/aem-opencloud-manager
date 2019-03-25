#!/usr/bin/env groovy
import common.*
import cloud.aws

/**
 * This script downloads a parameter artifact from a URL defined by user and
 * copies it to a destination directory, to be consumed by AEM OpenCloud
 * libraries (e.g. Packer AEM, AEM AWS Stack Builder).
 */
def call(script, String sourceDir, String fileName, String s3Bucket, String s3Path) {
  new aws().s3_upload(script, sourceDir, fileName, s3Bucket, s3Path)
}
