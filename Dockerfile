FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/*.jar like.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","like.jar"]