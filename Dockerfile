FROM adoptopenjdk/openjdk11

ADD target/41670-spring-boot-coder-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]