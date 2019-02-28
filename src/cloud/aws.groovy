#!/usr/bin/env groovy
// src/cloud/aws.groovy
package cloud

/**
 * Downloads an S3 object from specified bucket and path to a destination
 * directory. The object name is preserved and used as the downloaded file name.
 */
def s3_download(script, bucket, path, object, destDir, destObject=null) {
  if ( path != "" ) {
    path = "/" + path
  }
  if ( !destObject ) {
    destObject = object
  }
  script.sh """
  aws s3 cp s3://${bucket}${path}/${object} ${destDir}/${destObject}
  """
}

/**
 * Uploads a file from the specified source directory to an S3 bucket and path.
 * The file name is preserved as the S3 object name.
 */
def s3_upload(script, sourceDir, fileName, bucket, path) {
  script.sh """
  aws s3 cp ${sourceDir}/${fileName} s3://${bucket}/${path}/${fileName}
  """
}
