FROM openjdk:17-jdk-alpine

COPY target/gateway-service.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 9090
