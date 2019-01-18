#!/usr/bin/env bash

set -o errexit

playbook_type=$1
run_id=${RUN_ID:-$(date +%Y-%m-%d:%H:%M:%S)}
log_path=logs/$run_id-instalation.log

# Construct Ansible extra_vars flags.
# If CONFIG_FILE is set, values will be added.

# extra_vars=(--extra-vars "stack_prefix=$stack_prefix target_aem_stack_prefix=$target_aem_stack_prefix message_type=$message_type")

for config_file in $( find -L "${config_path}" -maxdepth 1 -type f -a \( -name '*.yaml' -o -name '*.yml' \) | sort ); do
  extra_vars+=( --extra-vars "@${config_file}")
done

# if [ ! -z "$6" ]; then
#     extra_vars+=(--extra-vars "$6")
# fi

mkdir -p logs
echo "Installing Jenkins pipelines..."
ANSIBLE_CONFIG=provisioners/ansible/ansible.cfg \
  ANSIBLE_LOG_PATH=$log_path \
  ansible-playbook "provisioners/ansible/playbooks/${playbook_type}.yaml" \
  -v \
  -i conf/ansible/inventory/hosts \
  --module-path provisioners/ansible/library/ \
  "${extra_vars[@]}"
echo "Finished"
