# Usa una imagen oficial de Tomcat con JDK 8
FROM tomcat:9.0-jdk8

# Borra las aplicaciones por defecto
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia tu archivo WAR al directorio de despliegue de Tomcat
COPY target/support.war /usr/local/tomcat/webapps/ROOT.war

# Expone el puerto 8080
EXPOSE 8080

# Inicia Tomcat
CMD ["catalina.sh", "run"]
