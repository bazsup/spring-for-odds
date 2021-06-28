# demo spring boot project


Gradle

```sh
./gradlew build
./gradlew bootRun  --args='--spring.profiles.active=uat'
```

Maven
```sh
./mvnw package
./mvnw spring-boot:run -Dspring-boot.run.profiles=uat
```

Jar file
```sh
# please build project before run this command
java -jar target/demo-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=uat
