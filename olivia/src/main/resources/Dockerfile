FROM openjdk:17-jdk-slim-buster

WORKDIR /app
COPY ./target/olivia-0.0.1-SNAPSHOT.jar /app

EXPOSE 8086

CMD ["java", "-jar", "olivia-0.0.1-SNAPSHOT.jar"]