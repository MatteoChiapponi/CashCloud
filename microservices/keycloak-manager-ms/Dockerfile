FROM openjdk:17-jdk-alpine

COPY target/keycloak-manager-service.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 8083
