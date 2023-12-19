# Stage 1: Build the application
FROM maven:3.8.6-eclipse-temurin-17-alpine as builder
WORKDIR /app

COPY ./pom.xml .

COPY ./book-service/pom.xml /book-service/pom.xml

# Package the application
RUN mvn package book-service/pom.xml

# Stage 2: Run the application
FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=builder /app/book-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
