FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/api-cabin-0.0.5-SNAPSHOT.jar /app/app-web/api-cabin.jar

EXPOSE

ENTRYPOINT ["java", "-jar", "/app/app-web/api-cabin.jar"]