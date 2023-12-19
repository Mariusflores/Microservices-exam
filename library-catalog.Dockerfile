FROM maven:3.8.6-eclipse-temurin-17-alpine as builder
WORKDIR /app

COPY ./pom.xml .

COPY ./library-catalog/pom.xml /library-catalog/pom.xml

# Package the application
RUN mvn package library-catalog/pom.xml

# Stage 2: Run the application
FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=builder /app/library-catalog/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]