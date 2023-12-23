# syntax=docker/dockerfile:1

FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Java_Server-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/Java_Server-1.0-SNAPSHOT.jar"]