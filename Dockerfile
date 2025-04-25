# --------- Build Stage ---------
FROM maven:3.9.4-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# --------- Run Stage ---------
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/Link-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
