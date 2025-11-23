# Use an OpenJDK image to build the application, as the Maven wrapper will download Maven
FROM openjdk:21-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Make the Maven wrapper executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN ./mvnw clean install -DskipTests

# Use a smaller OpenJDK image for the final image
FROM openjdk:21-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/cronjob-0.0.1-SNAPSHOT.jar .

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "cronjob-0.0.1-SNAPSHOT.jar"]
