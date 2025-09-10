FROM openjdk:17.0.1-jdk-slim
COPY --from=build server/target/server-0.0.1-SNAPSHOT.jar server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "server.jar"]
