FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/api-engine.jar /app/app-web/api-engine.jar

EXPOSE 6050

ENTRYPOINT ["java", "-jar", "/app/app-web/api-engine.jar"]