# Usa uma imagem com Java já instalada
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado pelo Spring Boot para dentro do container
COPY target/VidaDoada-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que o Spring Boot usa (padrão 8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
