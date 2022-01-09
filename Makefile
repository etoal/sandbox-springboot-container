.PHONY: clean build deploy

clean: stop-docker-container delete-docker-container delete-docker-image clean-app
##clean: clean-app

build: build-app build-docker

deploy: deploy-docker
	$(call printTaskHeader, Application has been deployed)

########## Clean Steps ##########
stop-docker-container:
	$(call printTaskHeader, Stopping Docker container)
	docker stop $$(docker ps -q --filter ancestor=ericoi/springboot-container) || true

delete-docker-container:
	$(call printTaskHeader, Deleting Docker container)
	docker rm $$(docker ps -a -q --filter ancestor=ericoi/springboot-container) || true

delete-docker-image:
	$(call printTaskHeader, Deleting ericoi/springboot-container image from Docker)
##sleeping for a few seconds to make sure that the K8s cluster has come down and isn't still using the Docker image (a little hacky)
	@sleep 7
	docker rmi ericoi/springboot-container || true

clean-app:
	$(call printTaskHeader, Cleaning application)
	gradle clean

########## Build Steps ##########
build-app:
	$(call printTaskHeader, Building application...)
	gradle build

build-docker:
	$(call printTaskHeader, Creating docker image ericoi/springboot-container)
	docker build -t ericoi/springboot-container .

########## Deploy Steps ##########
deploy-docker:
##would really make this run in the background (detatched mode) with -d
	docker run -p 8090:8090 ericoi/springboot-container

########## Help ##########
help:
	@echo ''
	@echo 'Usage make [TARGET]'
	@echo 'Targets:'
	@echo '  build     build application artifacts and Docker image'
	@echo '  deploy    deploy docker container'
	@echo '  clean     stop docker container, remove docker image, and clean application artifacts'

########## Functions ##########
define printTaskHeader
	@echo "** $(1) **"
endef



