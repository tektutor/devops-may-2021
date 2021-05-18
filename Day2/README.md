# Docker Commands

## Managing Docker Installation

### Installing Docker in Windows
https://docs.docker.com/docker-for-windows/install/

### Install docker in CentOS 
```
sudo yum install -y yum-utils
sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
sudo yum install docker-ce
sudo systemctl enable docker && sudo systemctl start docker
```

### Checking the Docker Engine(Server) status
```
sudo systemctl status docker
```

### Stopping the Docker Engine
```
sudo systemctl stop docker
```

### Restarting the Docker Engine
```
sudo systemctl restart docker
```

### Finding docker version
```
docker --version
```

### Finding docker install details
```
docker info
```

## Managing Docker Images

### Listing images from local registry
```
docker images
```

### Downloading docker image from Docker hub
```
docker pull hello-world:latest
docker pull ubuntu:16.04
```

### Removing(Deleting) Docker images
```
docker rmi hello-world:latest
```

### Inspecting Docker image
```
docker image inspect ubuntu:16.04
docker image inspect hello-world:latest
```

## Managing Containers

### Creating a container in interactive(foreground) mode
```
docker run -it --name c1 --hostname c1 ubuntu:16.04 /bin/bash
docker run -it --name c2 --hostname c2 ubuntu:16.04 /bin/bash
docker run -it --name c3 --hostname c3 ubuntu:16.04 /bin/bash
docker run -it --name c4 --hostname c4 ubuntu:16.04 /bin/bash
```

### Coming out of an interactive container shell without terminating container
```
Ctrl + q
```

### Removing containers
```
docker rm -f c1 c2 c3 c4
docker stop $(docker ps -q) && docker rm c1 c2 c3 c4
docker stop $(docker ps -q) && docker rm $(docker ps -aq)
docker rm -f $(docker ps -aq)
```

### Creating containers in background(daemon) mode
```
docker run -dit --name c1 --hostname c1 ubuntu:16.04 /bin/bash
docker run -dit --name c2 --hostname c2 ubuntu:16.04 /bin/bash
docker run -dit --name c3 --hostname c3 ubuntu:16.04 /bin/bash
docker run -dit --name c4 --hostname c4 ubuntu:16.04 /bin/bash
```

### Geting inside an already running container
```
docker exec -it c1 bash
```

### Stoping a container
```
docker stop c1
```

### Starting an exited container
```
docker start c1
```

### Restarting container
```
docker restart c1
```
### Renaming a container name
```
docker rename c1 server1
```
### Listing all running containers
```
docker ps
```
### List all containers even then exited ones
```
docker ps -a
```

### Inspecting a container
```
docker inspect c1
docker inspect c1 | grep Layers
docker inspect c1 | grep IPA
```

### Finding IP address of a container
```
docker inspect c1 | grep IPA
docker inspect -f {{.NetworkSettings.IPAddress}} c1
```

### Creating nginx web server containers
```
docker run -d --name web-server1 --hostname web-server1 nginx:1.18
docker run -d --name web-server2 --hostname web-server2 nginx:1.18
docker run -d --name web-server3 --hostname web-server3 nginx:1.18
```

### Finding the IP address of the nginx containeers
```
docker inspect web-server1 | grep IPA
docker inspect -f {{.NetworkSettings.IPAddress}} web-server2
```
We can get inside the container as shown below
```
docker exec -it web-server3 bash
```
Then we can try this below command to get the IP Address
```
hostname -i
```

### Accessing nginx web pages
Assuming 172.17.0.2 is the IPAddress of web-server1, 172.17.0.3 is the IPAddress of web-server2 and 172.17.04 is
the IPAddress of web-server3
```
curl http://172.17.0.2
curl http://172.17.0.3
curl http://172.17.0.4
```

### Port forwarding
```
docker run -d --name web1 --hostname web1 -p 8001:80 nginx:1.18
docker run -d --name web2 --hostname web2 -p 8002:80 nginx:1.18
docker run -d --name web3 --hostname web3 -p 8003:80 nginx:1.18
```

### Verify if all 3 nginx containers are running
```
docker ps
```

### Access the web from anywhere with RPS Network
```
ifconfig ens192
```
Assuming my RPS lab machine IP address is 192.168.18.126, the web pages can be accessed as shown below
```
curl http://192.168.18.126:8001
curl http://192.168.18.126:8002
curl http://192.168.18.126:8003
```

### Dispose existing containers
```
docker rm -f $(docker ps -aq)
```

### Create 3 nginx web server containers without port-forwarding
```
docker run -d --name web1 --hostname web1 nginx:1.18
docker run -d --name web2 --hostname web2 nginx:1.18
docker run -d --name web3 --hostname web3 nginx:1.18
```

### Create a Load Balancer nginx container with port forwarding
```
docker run -d --name lb --hostname lb -p 80:80 nginx:1.18
```
### Get inside the Load Balancer container
```
docker exec -it lb bash
```
Once you are inside the lb container shell,  type the below commands inside lb container shell
```
cd /etc/nginx
cat nginx.conf
pwd
```

Once you have investigated the nginx.conf file and its location,  come out of the lb  container
```
exit
```

### Copy the nginx.conf file from lb container to local machine
```
docker cp lb:/etc/nginx/nginx.conf .
```

### Edit the nginx.conf on your RPS Lab machine and make sure it looks as shown below
```
user  nginx;
worker_processes  1;

error_log  /var/log/nginx/error.log warn;
pid        /var/run/nginx.pid;

events {
    worker_connections  1024;
}

http {
    server {
        location / {
	   proxy_pass http://backend;
	}
    }

    upstream backend {
        server 172.17.0.2:80;
        server 172.17.0.3:80;
        server 172.17.0.4:80;
    }
}
```
The assumption is
```
172.17.0.2 is the IP Address of web1 container
172.17.0.3 is the IP Address of web2 container
172.17.0.4 is the IP Address of web3 container
```

### We need copy the nginx.conf file from local machine to lb container
```
docker cp nginx.conf lb:/etc/nginx/nginx.conf
```

### We need to restart lb container to apply the configuration changes
```
docker restart lb
```

### Ensure the lb container is still running
```
docker ps
```

### Optionally you could change the index.html files in web1, web2 and web3 containers as shown below
```
docker exec -it web1 bash
echo "Server 1" > /usr/share/nginx/html/index.html
exit
docker exec -it web2 bash
echo "Server 2" > /usr/share/nginx/html/index.html
exit
docker exec -it web3 bash
echo "Server 3" > /usr/share/nginx/html/index.html
exit
```

### You may now access the web page as shown below
```
curl http://192.168.18.126:80
curl http://192.168.18.126:80
curl http://192.168.18.126:80
```
You need to replace the IP address with your RPS Lab machine IP.

Each time to curl the URL,  you will get output something like
```
curl http://192.168.18.126:80
Server 1

curl http://192.168.18.126:80
Server 2

curl http://192.168.18.126:80
Server 3
```
