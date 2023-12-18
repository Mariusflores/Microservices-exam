FROM maven:3.8.6-eclipse-temurin-17-alpine as builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn package

FROM eclipse-temurin:17-alpine

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]