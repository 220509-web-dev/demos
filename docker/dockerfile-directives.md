`FROM <base-image-name>`
- initializes a new build stage and sets the base image
- a valid Dockerfile must start with a `FROM` instruction

`ENV key=test`
- sets the environment variable `key` to the value: `test`

`COPY <local-file> <destination-in-container>`
- instruction copies new files or directories from `<local-file>` and adds them to the filesystem of the container at the path `<destination-in-container>`

`CMD <command>`
- defines a command that will be ran when the container spins up
- there can only be one `CMD` instruction in a Dockerfile

`VOLUME <directory-on-local-machine>`
- directories and files that exist on the host file system outside of the Docker container
- used to persist data and share data between Docker containers
