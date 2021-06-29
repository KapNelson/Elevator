FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/api-admin.jar /app/app-web/api-admin.jar

EXPOSE 6060

ENTRYPOINT ["java", "-jar", "/app/app-web/api-admin.jar"]