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

### Copy the settings.xml file from devops-may-2021/Day3/CRM folder
```
cd devops-may-2021/Day3/CRM
git pull
cp settings.xml /home/devops/Downloads/apache-maven-3.8.1/conf
```
### Create SonarQube container
```
docker run -d --name sonar --hostname sonar sonarqube:latest
```

### Verify if SonarQube is running
```
docker ps
```

### Check if you can access the SonarQube web page
```
http://172.17.0.2:9000
```
#### Default Login Credentials are
user - admin
password - admin

Assumption is, 172.17.0.2 is the IP address of the SonarQube container, your container IP might be different.

### POM file configurations for SonarQube Integration
In the pom.xml file,  you need to add the below properties anywhere within the project root tag
```
<properties>
  <sonar.host.url></sonar.host.url>
  <sonar.login>admin</sonar.login>
  <sonar.password>Admin@123</sonar.password>
</properties>
```
Also we need to add the below plugin
```
<build>
  <plugins>
      <plugin
        <groupId>org.sonarsource.scanner.maven</groupId>
        <artifactId>sonar-maven-plugin</artifactId>
        <version>3.9.0.2155</version>>
      </plugin>
  </plugins>
</build>>
```

### Finding SonarQube plugin goals
```
mvn help:describe -Dplugin=org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155 -Ddetail
```
### Performing code coverage and static code analysis of CRM project using SonarQube
```
mvn clean package
mvn sonar:sonar
```
