#!/usr/bin/env groovy
import cloud.aws

def call(script, String sourceAuthorSnapshotId, String sourcePublishSnapshotId, String configPath) {
  script.sh """
  echo -e "\n
  snapshots:
    author:
      use_data_vol_snapshot: true
      data_vol_snapshot_id: ${sourceAuthorSnapshotId}
    publish:
      use_data_vol_snapshot: true
      data_vol_snapshot_id: ${sourcePublishSnapshotId}" > ${configPath}/offline_snapshot.yaml
  """
}
