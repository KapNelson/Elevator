FROM openjdk:17

RUN mkdir -p /app/app-web

COPY target/srv-config.jar /app/app-web/srv-config.jar

EXPOSE 6002

ENTRYPOINT ["java", "-jar", "/app/app-web/srv-config.jar"]