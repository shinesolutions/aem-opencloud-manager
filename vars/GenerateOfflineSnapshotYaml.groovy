#!/usr/bin/env groovy
import cloud.aws

def call(script, String sourceAuthorSnapshotId, String sourcePublishSnapshotId, String configPath) {

  def extra_conf = "snapshots:"
  if ( sourceAuthorSnapshotId ) {
    extra_conf += """
  author:
    use_data_vol_snapshot: true
    data_vol_snapshot_id: ${sourceAuthorSnapshotId}"""
  }
  if ( sourcePublishSnapshotId ) {
      extra_conf += """
  publish:
    use_data_vol_snapshot: true
    data_vol_snapshot_id: ${sourcePublishSnapshotId}"""
  }

  script.sh """
    mkdir -p ${configPath}/
    echo -e "${extra_conf}" > ${configPath}/zzz_offline_snapshot.yaml
  """
}
