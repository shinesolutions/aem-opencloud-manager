#!/usr/bin/env bash
set -o errexit

if [[ "$#" -lt 1 ]] || [[ "$#" -gt 3 ]]; then
  echo "Usage: ${0} <playbook_type> <config_path> [stack_prefix]"
  exit 1
fi

playbook_type="${1}"
config_path="${2}"
stack_prefix="${3}"
run_id=${RUN_ID:-$(date +%Y-%m-%d:%H:%M:%S)}
log_path=logs/$run_id-provisioning.log

# Construct Ansible extra_vars flags. If `config_path` is set, all files
# directly under the directory with extension `.yaml` or `.yml` will be added.
# The search for config files _will not_ descend into subdirectories.
extra_vars=(--extra-vars "stack_prefix=$stack_prefix")
for config_file in $( find -L "${config_path}" -maxdepth 1 -type f -a \( -name '*.yaml' -o -name '*.yml' \) | sort ); do
  extra_vars+=( --extra-vars "@${config_file}")
done

mkdir -p logs
echo "Executing playbook ${playbook_type}..."
ANSIBLE_CONFIG=conf/ansible/ansible.cfg \
  ANSIBLE_LOG_PATH=$log_path \
  ansible-playbook "provisioners/ansible/playbooks/${playbook_type}.yaml" \
  -i conf/ansible/inventory/hosts \
  --module-path provisioners/ansible/library/ \
  "${extra_vars[@]}"
echo "Finished executing playbook ${playbook_type}"
