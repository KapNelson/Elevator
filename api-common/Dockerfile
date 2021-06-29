FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/api-common.jar /app/app-web/api-common.jar

ENTRYPOINT ["java", "-jar", "/app/app-web/api-common.jar"]