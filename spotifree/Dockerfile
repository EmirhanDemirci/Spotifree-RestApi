FROM openjdk:8-jdk-alpine


ADD target/spotifree-0.0.1-SNAPSHOT.jar spotifree-api.jar

ENTRYPOINT ["java", "-jar", "spotifree-api.jar"]
EXPOSE 8080