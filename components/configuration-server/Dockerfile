FROM openjdk:17-jdk-alpine

RUN /Users/matteo/Desktop/CashCloud/components/configuration-server/generate_executable.sh
COPY target/configuration-server.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 8888