FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/api-engine-0.0.4-SNAPSHOT.jar /app/app-web/api-engine.jar

EXPOSE 6010

ENTRYPOINT ["java", "-jar", "/app/app-web/api-engine.jar"]