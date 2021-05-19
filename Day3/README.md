### Downloading JFrog Artifactory docker image
```
docker pull docker.bintray.io/jfrog/artifactory-oss:latest
```

### Creating JFrog Artifactory container
```
docker run -d --name artifactory --hostname artifactory -p 8081:8081 docker.bintray.io/jfrog/artifactory-oss:latest
```

### You may now verify if the JFrog Artifactory container is up and running
```
docker ps
```

### You can try accessing JFrog Artifactory webpage from RPS Lab machine web browser
```
http://localhost:8081
```
