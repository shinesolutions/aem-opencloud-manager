#!/usr/bin/env bash
set -o errexit

playbook_type=$1
run_id=${RUN_ID:-$(date +%Y-%m-%d:%H:%M:%S)}
log_path=logs/$run_id-provisioning.log

for config_file in $( find -L "${config_path}" -maxdepth 1 -type f -a \( -name '*.yaml' -o -name '*.yml' \) | sort ); do
  extra_vars+=( --extra-vars "@${config_file}")
done

mkdir -p logs
echo "Provisioning Jenkins pipelines..."
ANSIBLE_CONFIG=provisioners/ansible/ansible.cfg \
  ANSIBLE_LOG_PATH=$log_path \
  ansible-playbook "provisioners/ansible/playbooks/${playbook_type}.yaml" \
  -v \
  -i conf/ansible/inventory/hosts \
  --module-path provisioners/ansible/library/ \
  "${extra_vars[@]}"
echo "Finished provisioning Jenkins resources"
