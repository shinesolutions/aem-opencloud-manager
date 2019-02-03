DOCKER_IMAGE := aem-opencloud/jenins-master:latest
CONTAINER_NAME := jenkins

ci: clean deps lint

stage:
	mkdir -p stage/

clean:
	rm -rf logs
	rm -fr stage


run: clean build
	docker run -p 8080:8080 --name "${CONTAINER_NAME}" "${DOCKER_IMAGE}"

build:
	docker build . -t "${DOCKER_IMAGE}"

deps:
	pip install -r requirements.txt

lint:
	ansible-lint ansible/playbooks/*/*.yaml

aws-manager-data:
	./scripts/run-playbook.sh manager-data "$(config_path)"

aws-installation: stage
	./scripts/run-playbook.sh installation "$(config_path)"

.PHONY: ci clean deps lint create-ci-aws delete-ci-aws
