#!/usr/bin/env groovy
import cloud.aws

def call(script, String sourceAuthorSnapshotId = null , String sourcePublishSnapshotId = null, String sourceStackPrefix = null, String configPath, String aws_region) {
  if ( sourceAuthorSnapshotId || sourcePublishSnapshotId ) {
    GenerateOfflineSnapshotYaml(this, sourceAuthorSnapshotId, sourcePublishSnapshotId, configPath)
  } else if ( sourceStackPrefix ) {
    GenerateOfflineSnapshotYamlStackNameV2(this, sourceStackPrefix, configPath, aws_region)
  }
}
