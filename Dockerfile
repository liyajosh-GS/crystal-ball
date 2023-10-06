# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim-buster

# Set the working directory
WORKDIR /app

# Copy the Spring Boot application JAR into the container
COPY target/crystalBall-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (default is 8080)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
