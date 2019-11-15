FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=target/client-*.jar

ADD ${JAR_FILE} client.jar

ENTRYPOINT ["java","-jar","/client.jar"]