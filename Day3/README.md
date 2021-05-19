### Downloading JFrog Artifactory docker image
```
docker pull docker.bintray.io/jfrog/artifactory-oss:latest
```

### Creating JFrog Artifactory container
```
docker run -d --name artifactory --hostname artifactory -p 8081:8081 docker.bintray.io/jfrog/artifactory-oss:latest
```
