# sandbox-springboot-container

This is an example Java springboot project which creates a Docker image and runs in a Docker container.

# Prerequisites
Git <br>
Java 11+ <br>
Gradle <br>
Docker <br>
make <br>

# Building
To build the application run:

```make build```

# Deploying
To deploy the Docker image run:

```make deploy```

# Try it out
Now you can hit the app by pointing your browser to one of the following urls:

```http://localhost:8090/greeting```

```http://localhost:8090/greeting?name=Eric```

# Stop/Clean
To stop the Docker container, remove the container and remove the Docker image and clean the application artifacts run:

```make clean```