# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the application jar file to the container
COPY target/todo26-1.0-SNAPSHOT.jar /app/todo-app.jar

# Copy the configuration files
COPY config.yml /app/config.yml

# Expose the port the application runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "todo-app.jar", "server", "config.yml"]
