# Stage 1: Build the application
FROM maven:3.8.6-eclipse-temurin-17-alpine as builder
WORKDIR /app
# Copy the parent pom.xml
COPY pom.xml .
# Copy the api-gateway module pom.xml and source code
COPY book-service/pom.xml ./book-service/pom.xml
COPY book-service/src ./book-service/src
# Package the application
RUN mvn -f api-gateway/pom.xml clean package

# Stage 2: Run the application
FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=builder /app/api-gateway/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
