#!/usr/bin/env groovy
import cloud.aws

def call(script, String sourceStackPrefix, String configPath) {
  authorSnapshotId = new aws().get_latest_ec2_snapshot(script, sourceStackPrefix, 'author', 'offline')
  publishSnapshotId = new aws().get_latest_ec2_snapshot(script, sourceStackPrefix, 'publish', 'offline')
  GenerateOfflineSnapshotYaml(script, authorSnapshotId, publishSnapshotId, configPath)
}
