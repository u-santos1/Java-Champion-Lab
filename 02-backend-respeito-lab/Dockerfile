
# FASE 1: BUILD

FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app

  # Copia apenas o pom.xml primeiro (otimiza o cache do Docker)
COPY pom.xml .
RUN mvn dependency:go-offline -B

  # Copia o código-fonte e compila o .jar
COPY src ./src
RUN mvn clean package -DskipTests


  # FASE 2: RUNTIME (O Produto Final)

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

  # Pega EXATAMENTE no .jar gerado na Fase 1 e atira para este contentor limpo
COPY --from=builder /app/target/*.jar app.jar

  # Expõe a porta que o Spring Boot vai usar
EXPOSE 8080

  # O comando de ignição
ENTRYPOINT ["java", "-jar", "app.jar"]