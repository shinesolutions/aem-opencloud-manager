DOCKER_IMAGE := aem-opencloud/jenkins-master:latest
CONTAINER_NAME := jenkins

ci: clean deps lint jenkins-aws-gen

stage:
	mkdir -p stage/

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
# Generate pipelines and provision them to a Jenkins instance.
################################################################################

jenkins-aws: jenkins-aws-gen jenkins-aws-provision

jenkins-aws-gen:
	rm -rf stage/jenkins/jobs/aem-opencloud-*/
	./scripts/run-playbook.sh jenkins-aws-gen "$(config_path)"

jenkins-aws-provision: stage
	./scripts/run-playbook.sh jenkins-aws-provision "$(config_path)"

################################################################################
# Integration test targets.
################################################################################

test-integration: deps deps-test
	./test/integration/test-examples.sh "$(cicd_type)" "$(cloud_type)"

test-integration-local: deps deps-test-local
	./test/integration/test-examples.sh "$(cicd_type)" "$(cloud_type)"

################################################################################
# Temporary utility targets
################################################################################

docker-run: clean docker-build
	docker run -p 8080:8080 --name "${CONTAINER_NAME}" "${DOCKER_IMAGE}"

docker-build:
	docker build . -t "${DOCKER_IMAGE}"

.PHONY: ci stage clean deps deps-test deps-test-local lint jenkins-aws jenkins-aws-gen jenkins-aws-provision docker-run docker-build
