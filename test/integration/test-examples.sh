#!/usr/bin/env bash
set -o errexit

# This script is used for integration testing the provisioning of AEM OpenCloud
# Manager on a Jenkins instance and then the builds will be run against them.

if [[ "$#" -lt 1 ]] || [[ "$#" -gt 3 ]]; then
  echo "Usage: ${0} <test_id> [cicd_type] [platform_type]"
  exit 1
fi

cicd_type=$1
platform_type=$2

make "${cicd_type}-${platform_type}" config_path=stage/user-config/sandpit/
