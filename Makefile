DOCKER_IMAGE := aem-opencloud/jenkins-master:latest
CONTAINER_NAME := jenkins

ci: clean deps lint jenkins-aws-gen-pipelines

stage:
	mkdir -p stage/

clean:
	rm -rf logs/ stage/

run: clean build
	docker run -p 8080:8080 --name "${CONTAINER_NAME}" "${DOCKER_IMAGE}"

build:
	docker build . -t "${DOCKER_IMAGE}"

deps:
	pip install -r requirements.txt

lint:
	# ansible-lint provisioners/ansible/playbooks/*.yaml

jenkins-aws: jenkins-aws-gen-pipelines jenkins-aws-provision-pipelines

jenkins-aws-gen-pipelines:
	rm -rf stage/jenkins/jobs/aem-opencloud-*/
	./scripts/run-playbook.sh jenkins-aws-gen-pipelines "$(config_path)"

jenkins-aws-provision-pipelines: stage
	./scripts/run-playbook.sh jenkins-aws-provision-pipelines "$(config_path)"

.PHONY: ci clean deps lint create-ci-aws delete-ci-aws
