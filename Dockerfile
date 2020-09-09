FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} mini-kafka-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/mini-kafka-1.0-SNAPSHOT.jar"]