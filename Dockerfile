# ==========================
# Stage 1 - Build the application
# ==========================
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml first for dependency caching
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# ==========================
# Stage 2 - Run the application
# ==========================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy generated JAR
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]