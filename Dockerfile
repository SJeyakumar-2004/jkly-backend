# Use an official JDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the specific JAR file into the container
COPY target/Link-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app listens on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
