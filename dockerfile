FROM openjdk:19-jdk-slim
WORKDIR /app
COPY target/UserMicroService-0.0.1-SNAPSHOT.jar /app
EXPOSE 8002
CMD ["java", "-jar", "UserMicroService-0.0.1-SNAPSHOT.jar"]