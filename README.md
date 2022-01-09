# sandbox-springboot-container

This is an example Java SpringBoot project which creates a Docker image and runs in a Kubernetes cluster with Load Balancing between 2 instances.

# Checkin History
History of git project checkins demonstrates:
1. Regular Springboot Rest application
2. Deploy the above to Docker image/container
3. Deploy the Docker image to Kubernetes cluster with Load Balancing

# Prerequisites
Git <br>
Java 11+ <br>
Gradle <br>
Docker <br>
Kubernetes <br>
make <br>

# Building
To build the application run:

```make build```

# Deploying
To deploy the Docker image to Kubernetes run:

```make deploy```

# Try it out
Now you can hit the app by pointing your browser to one of the following urls:

```http://localhost:8090/greeting```

```http://localhost:8090/greeting?name=Eric```

# Stop/Clean
To stop the Kubernetes cluster & load balancer as well as remove the Docker image and clean the application artifacts run:

```make clean```