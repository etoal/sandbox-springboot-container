.PHONY: clean build deploy

clean: delete-k8s delete-docker-image clean-app

build: build-app build-docker-image

deploy: deploy-k8s-service deploy-k8s-lb
	$(call printTaskHeader, Application has been deployed)

########## Clean Steps ##########
delete-k8s: delete-k8s-lb delete-k8s-service

delete-k8s-lb:
	$(call printTaskHeader, Deleting springboot-container-lb Load Balancer Service from K8s)
	kubectl delete -f resource-manifests/springboot-container-lb.yaml || true

delete-k8s-service:
	$(call printTaskHeader, Deleting springboot-container Deployment from K8s)
	kubectl delete -f resource-manifests/springboot-container.yaml || true

delete-docker-image:
	$(call printTaskHeader, Deleting ericoi/springboot-container image from Docker)
##sleeping for a few seconds to make sure that the K8s cluster has come down and isn't still using the Docker image (a little hacky)
##sometimes the sleep still isn't enough.  Run it again to delete the image (there must be a better way, but not wasting time right now)
	@sleep 7
	docker rmi ericoi/springboot-container || true

clean-app:
	$(call printTaskHeader, Cleaning application)
	gradle clean

########## Build Steps ##########
build-app:
	$(call printTaskHeader, Building application...)
	gradle build

build-docker-image:
	$(call printTaskHeader, Creating docker image ericoi/springboot-container)
	docker build -t ericoi/springboot-container .

########## Deploy Steps ##########
deploy-k8s-service:
	$(call printTaskHeader, Creating K8s Deployment springboot-container)
	kubectl create -f resource-manifests/springboot-container.yaml

deploy-k8s-lb:
	$(call printTaskHeader, Creating K8s LoadBalancer Service springboot-container-lb)
	kubectl create -f resource-manifests/springboot-container-lb.yaml

########## Help ##########
help:
	@echo ''
	@echo 'Usage make [TARGET]'
	@echo 'Targets:'
	@echo '  build     build application artifacts and Docker image'
	@echo '  deploy    deploy docker image to Kubernetes'
	@echo '  clean     delete Kubernetes cluster, remove docker image, and clean application artifacts'

########## Functions ##########
define printTaskHeader
	@echo "** $(1) **"
endef



