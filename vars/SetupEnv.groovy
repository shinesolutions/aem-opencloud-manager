#!/usr/bin/env groovy

def call(script) {
  // Install awscli which is required by the other pipelines.
  script.sh """apt update && \
    apt install -y python-pip && \
    pip install awscli
  """
}
