FROM openjdk:21-jdk
COPY target/*.jar inventory.jar
EXPOSE 8080
ENTRYPOINT["java","-jar","inventory.jar"]