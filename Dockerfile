# Etapa 1: Construir o projeto
FROM gradle:8.8-jdk-21-and-22 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build -x test --no-daemon

# Etapa 2: Imagem final
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
