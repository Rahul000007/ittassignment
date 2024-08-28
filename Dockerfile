FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/IITAssignment-0.0.1-SNAPSHOT.jar IITAssignment.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "IITAssignment.jar"]
