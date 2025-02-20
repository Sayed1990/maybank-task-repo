# Use JDK 21 for building the application
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copy project files
COPY . .


# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Use JDK 21 for running the application
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the generated WAR file from the build stage
COPY --from=build /app/target/user-management-1.0.0.war app.war

EXPOSE 8080
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.war"]