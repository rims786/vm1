# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Create a volume for the H2 database files
VOLUME /app/data

# Package the application
RUN ./mvnw package

# Run the application
CMD ["java", "-jar", "target/vm1-1.0.0.jar"]