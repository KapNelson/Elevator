FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/api-cabin-floor.jar /app/app-web/api-cabin-floor.jar

EXPOSE 6070

ENTRYPOINT ["java", "-jar", "/app/app-web/api-cabin-floor.jar"]