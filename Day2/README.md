# Docker Commands

### Finding docker version
```
docker --version
```

### Finding docker install details
```
docker info
```

### Listing images from local registry
```
docker images
```

### Downloading docker image from Docker hub
```
docker pull hello-world:latest
docker pull ubuntu:16.04
```

### Creating a container in interactive(foreground) mode
```
docker run -it --name c1 --hostname c1 ubuntu:16.04 /bin/bash
docker run -it --name c2 --hostname c2 ubuntu:16.04 /bin/bash
docker run -it --name c3 --hostname c3 ubuntu:16.04 /bin/bash
docker run -it --name c4 --hostname c4 ubuntu:16.04 /bin/bash
```

### Removing containers
```
docker rm -f c1 c2 c3 c4
docker stop $(docker ps -q) && docker rm c1 c2 c3 c4
```

### Creating containers in background(daemon) mode
```
docker run -dit --name c1 --hostname c1 ubuntu:16.04 /bin/bash
docker run -dit --name c2 --hostname c2 ubuntu:16.04 /bin/bash
docker run -dit --name c3 --hostname c3 ubuntu:16.04 /bin/bash
docker run -dit --name c4 --hostname c4 ubuntu:16.04 /bin/bash
```

### Stoping a container
docker stop c1

### Starting an exited container
docker start c1

### Restarting container
docker restart c1

### Renaming a container name
docker rename c1 server1

### Listing all running containers
docker ps

### List all containers even then exited onees
docker ps -a
