FROM openjdk:17-jdk-alpine

CMD ["bash", "generate_executable.sh"]
COPY target/eureka-server.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
EXPOSE 8761