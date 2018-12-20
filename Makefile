DOCKER_IMAGE := aem-opencloud/jenins-master:latest
CONTAINER_NAME := jenkins

ci: clean deps lint

clean:
	@docker rm -f "${CONTAINER_NAME}" >/dev/null 2>&1 || true

run: clean build
	docker run -p 8080:8080 --name "${CONTAINER_NAME}" "${DOCKER_IMAGE}"

build:
	docker build . -t "${DOCKER_IMAGE}"

deps:
	pip install -r requirements.txt

lint:
	ansible-lint ansible/playbooks/*/*.yaml

.PHONY: ci clean deps lint create-ci-aws delete-ci-aws
