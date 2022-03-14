FROM openjdk:11-jdk-slim
COPY target/dyndoc-configurator-ui-backend-0.0.1-SNAPSHOT.jar dyndoc-configurator-ui-backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xdebug", "-Xrunjdwp:transport=dt_socket,address=*:8000,server=y,suspend=n", \
"-jar","dyndoc-configurator-ui-backend.jar", "-Djava.awt.headless=true"]
