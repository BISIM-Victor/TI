FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia todo tu código primero
COPY . .

# Luego construye
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Ejecuta tu jar
CMD ["java", "-jar", "target/miapp.jar"]
