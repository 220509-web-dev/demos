Check version of Docker: `docker --version`

Run basic hello world: `docker run hello-world`

Build a Docker image (assumes you have a Dockerfile in the same directory): `docker build -t docker-test .`

Run a Docker image as a container that is detached from the current terminal: `docker run -d docker-test`

See running containers: `docker ps`

See all containers (even if not running): `docker ps -a`

Connect to the shell of a running Docker container: `docker exec -it <CONTAINER_NAME> /bin/bash`
