FROM openjdk:17-jdk-alpine

COPY target/notification-service.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 8082
