# Commonly used Maven commands

### Checking Maven version
'''
mvn --version
'''

### Compiling application source code in a Maven project
```
mvn compile
```

### Compiling and running test cases
```
mvn test
```

### Creating a package ( jar,war,ear, etc., )
```
mvn package
```

### Installing the artifacts into Maven Local Repository
```
mvn install
```

### Deploying the artifacts into Nexus/Artifactory
```
mvn deploy
```

### Listing all the phases in default life-cycle
```
mvn help:describe -Dcmd=compile
```

### Listing all the phases in clean life-cycle
```
mvn help:describe -Dcmd=clean
```

### Listing all the phases in site life-cycle
```
mvn help:describe -Dcmd=site
```

### Listing goals supported by a Maven plugin
```
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin:3.1
```

### Listing goals supported by a Maven plugin with details goal parameters supported
```
mvn help:describe -Dplugin=org.apache.maven.plugins:maven-compiler-plugin:3.1 -Ddetail
```

### Printing Maven effective pom
```
mvn help:effective-pom
```

### Printing Maven effective setting
```
mvn. help:effective-settings
```

### Deleting the target directory
```
mvn clean
```
