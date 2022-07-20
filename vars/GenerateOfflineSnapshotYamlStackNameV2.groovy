#!/usr/bin/env groovy
import cloud.aws

def call(script, String sourceStackPrefix, String configPath, String aws_region) {
  authorSnapshotId = new aws().get_latest_ec2_snapshot_v2(script, sourceStackPrefix, 'author', 'offline', aws_region)
  publishSnapshotId = new aws().get_latest_ec2_snapshot_v2(script, sourceStackPrefix, 'publish', 'offline', aws_region)
  if (! (authorSnapshotId || publishSnapshotId) ) {
    error("Stack: ${sourceStackPrefix} lookup did not returned any snapshots (neither author or publish)")
  }
  GenerateOfflineSnapshotYaml(script, authorSnapshotId, publishSnapshotId, configPath)
}
