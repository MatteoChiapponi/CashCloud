FROM openjdk:17-jdk-alpine

COPY target/accounts-service.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 8084
