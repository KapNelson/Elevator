FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/api-common-0.0.4-SNAPSHOT.jar /app/app-web/api-common.jar

ENTRYPOINT ["java", "-jar", "/app/app-web/api-common.jar"]