# Etapa 1: Construcción del WAR con Maven
FROM maven:3.8.6-openjdk-8 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el código fuente
COPY pom.xml /app
COPY src /app/src

# Construye el WAR
RUN mvn clean package -DskipTests

# Etapa 2: Despliegue en Tomcat
FROM tomcat:9.0-jdk8

# Elimina cualquier archivo WAR por defecto en Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia el WAR generado desde la etapa anterior
COPY --from=build /app/target/support.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto 8080 para acceder a la app
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
