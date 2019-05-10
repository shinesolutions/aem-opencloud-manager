#!/usr/bin/env groovy
import cloud.aws

def call(script, String sourceStackPrefix, String configPath) {
  authorSnapshotId = new aws().get_latest_ec2_snapshot(script, sourceStackPrefix, 'author', 'offline')
  publishSnapshotId = new aws().get_latest_ec2_snapshot(script, sourceStackPrefix, 'publish', 'offline')
  if (! (authorSnapshotId || publishSnapshotId) ) {
    error("Stack: ${sourceStackPrefix} lookup did not returned any snapshots (neither author or publish)")
  }
  GenerateOfflineSnapshotYaml(script, authorSnapshotId, publishSnapshotId, configPath)
}
