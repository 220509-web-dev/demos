# Common Docker commands


## Sanity check commands

These commands are useful to ensure that you have installed Docker and it is working properly.

- Check version of Docker: `docker --version`
- Run basic hello world: `docker run hello-world`


## A simple Docker workflow

These commands make up the most basic workflow you can expect to use when using Docker to containerize your applications.

- Build a Docker image (assumes you have a Dockerfile in the same directory): `docker build -t <IMAGE_NAME> .`
- Run a Docker image as a container that is detached from the current terminal: `docker run -d <IMAGE_NAME>`
- Starting a stopped Docker container: `docker start <CONTAINER_NAME>`
- Stopping a running Docker container (can be restarted): `docker stop <CONTAINER_NAME>`
- Move files from host machine to running Docker container: `docker cp <file-on-host> <CONTAINER_NAME>:<destination-in-container>`
- Move files from running Docker container to host machine: `docker cp <CONTAINER_NAME>:<file-in-container> <destination-on-host>`

## See what's going on

These commands are useful to give you an idea of what your Docker engine is currently running and what things it has saved locally onto your machine.

- See all Docker images on your machine: `docker images`
- See running containers: `docker ps`
- See all containers (even if not running): `docker ps -a`

## Cleaning up

These commands are useful for removing locally stored data (stopped containers, old images, volumes, etc.). 

- Remove a Docker image: `docker rmi <IMAGE_NAME>`
- Remove a stopped Docker container: `docker rm <CONTAINER_NAME>`
- Remove all stopped Docker containers: `docker container prune`
- Remove all images: `docker rmi $(docker images -a -q)`
- Remove everything saved locally: `docker system prune`

## Using Docker to run a database

These commands are specific to the situation of using Docker to run a container based on the official PostgreSQL image on DockerHub.

- Connect to the shell of a running Docker container: `docker exec -it <CONTAINER_NAME> /bin/bash`
- Run a PostgreSQL DB as a Docker container: `docker run --name local-db -p 5432:5432 -e POSTGRES_PASSWORD=revature -d postgres`
- Connect directly to a containerized PostgreSQL DB using `psql`: `docker exec -it <CONTAINER_NAME> psql -U postgres -h localhost`

