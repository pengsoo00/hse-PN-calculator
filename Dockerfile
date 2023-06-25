FROM openjdk:17

CMD ["./mvnw", "clean", "package"]
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hse-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "hse-0.0.1-SNAPSHOT.jar"]

EXPOSE 808