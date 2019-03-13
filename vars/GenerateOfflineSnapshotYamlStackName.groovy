#!/usr/bin/env groovy
import cloud.aws

def call(script, String stackPrefix, String configPath) {
  authorSnapshotId = new aws().get_latest_ec2_snapshot(script, stack_prefix, 'author', 'offline')
  publishSnapshotId = new aws().get_latest_ec2_snapshot(script, stack_prefix, 'publish', 'offline')
  GenerateOfflineSnapshotYaml(script, authorSnapshotId, publishSnapshotId, configPath)
}
