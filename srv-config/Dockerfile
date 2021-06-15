FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/srv-config-0.0.4-SNAPSHOT.jar /app/app-web/api-config.jar

ENTRYPOINT ["java", "-jar", "/app/app-web/api-config.jar"]