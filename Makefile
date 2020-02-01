ci: clean deps lint test-jenkins-aws-gen

stage:
	mkdir -p stage/user-config/ stage/jenkins-plugins/

clean:
	rm -rf logs/ stage/

################################################################################
# Dependencies resolution targets.
# For deps-test-local target, the local dependencies must be available on the
# same directory level where aem-opencloud-manager is at. The idea is that you
# can test AEM OpenCloud Manager while also developing those dependencies locally.
################################################################################

# resolve dependencies from remote artifact registries
deps:
	pip install -r requirements.txt

# resolve test dependencies from remote artifact registries
deps-test: stage
	rm -rf stage/aem-helloworld-config/ stage/user-config/*
	cd stage && git clone https://github.com/shinesolutions/aem-helloworld-config
	cp -R stage/aem-helloworld-config/aem-opencloud-manager/* stage/user-config/

# resolve test dependencies from local directories
deps-test-local: stage
	rm -rf stage/aem-helloworld-config/ stage/user-config/*
	cp -R ../aem-helloworld-config/aem-opencloud-manager/* stage/user-config/

################################################################################
# Code styling check and validation targets:
# - lint Ansible playbooks
################################################################################

lint:
	# ansible-lint provisioners/ansible/playbooks/*.yaml

################################################################################
# Provision Jenkins with plugins and pipelines.
# Generate pipelines and provision them to a Jenkins instance.
################################################################################

jenkins-init: stage
	./scripts/run-playbook.sh jenkins-init "$(config_path)"

jenkins-aws: jenkins-aws-gen jenkins-aws-provision

jenkins-aws-gen: stage
	rm -rf stage/jenkins/jobs/aem-opencloud-*/
	./scripts/run-playbook.sh jenkins-aws-gen "$(config_path)"

jenkins-aws-provision:
	./scripts/run-playbook.sh jenkins-aws-provision "$(config_path)"

################################################################################
# Provision AWS resources
# Create below prerequisite resources inorder to run OpenCloud
#       - Artefact s3 buckets
#       - Bucket policy
#       - Instance profile and roles
################################################################################

jenkins-aws-resources:
	./scripts/run-playbook.sh jenkins-aws-user-resources "$(config_path)" "$(stack_prefix)"

################################################################################
# Integration test targets.
################################################################################

test-integration: clean deps deps-test
	./test/integration/test-examples.sh "$(cicd_type)" "$(platform_type)"

test-integration-local: clean deps deps-test-local
	./test/integration/test-examples.sh "$(cicd_type)" "$(platform_type)"

# only tests jenkins-aws pipelines generation
# this is used for Travis CI testing which doesn't have access to any public
# facing Jenkins instance
test-jenkins-aws-gen: deps deps-test
	make jenkins-aws-gen config_path=stage/user-config/sandpit/

test-jenkins-pipelines: test-jenkins-pipelines-installation test-jenkins-pipelines-machine-images test-jenkins-pipelines-manage-environments test-jenkins-pipelines-migration test-jenkins-pipelines-operational-tasks test-jenkins-pipelines-testing

test-jenkins-pipelines-installation:
	$(call test_jenkins_pipeline,'installation')

test-jenkins-pipelines-machine-images:
	$(call test_jenkins_pipeline,'machine-images')

test-jenkins-pipelines-manage-environments:
	$(call test_jenkins_pipeline,'manage-environments')

test-jenkins-pipelines-migration:
	$(call test_jenkins_pipeline,'migration')

test-jenkins-pipelines-operational-tasks:
	$(call test_jenkins_pipeline,'operational-tasks')

test-jenkins-pipelines-testing:
	$(call test_jenkins_pipeline,'testing')

define test_jenkins_pipeline
  test_category=$(1) ./scripts/run-playbook.sh jenkins-pipelines-run "$(config_path)"
endef

################################################################################
# Temporary utility targets
################################################################################

DOCKER_IMAGE := aem-opencloud/jenkins-master:latest
CONTAINER_NAME := jenkins

docker-run: clean docker-build
	docker run -p 8080:8080 --name "${CONTAINER_NAME}" "${DOCKER_IMAGE}"

docker-build:
	docker build . -t "${DOCKER_IMAGE}"

.PHONY: ci stage clean deps deps-test deps-test-local lint jenkins-aws jenkins-aws-gen jenkins-aws-provision docker-run docker-build
