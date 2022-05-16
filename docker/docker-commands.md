Check version of Docker: `docker --version`

Run basic hello world: `docker run hello-world`

Build a Docker image (assumes you have a Dockerfile in the same directory): `docker build -t docker-test .`

Run a Docker image as a container that is detached from the current terminal: `docker run -d docker-test`

See running containers: `docker ps`

See all containers (even if not running): `docker ps -a`

Remove a stopped Docker container: `docker rm <CONTAINER_NAME`

Remove all stopped Docker containers: `docker container prune`

Connect to the shell of a running Docker container: `docker exec -it <CONTAINER_NAME> /bin/bash`

---

Run a PostgreSQL DB as a Docker container: `docker run --name local-db -p 5432:5432 -e POSTGRES_PASSWORD=revature -d postgres`

Connect directly to a containerized PostgreSQL DB using `psql`: `docker exec -it <CONTAINER_NAME> psql -U postgres -h localhost`


