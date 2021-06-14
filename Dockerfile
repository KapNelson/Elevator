FROM openjdk:17

RUN mkdir -p /app/app-web

COPY api-admin/target/api-admin-0.0.3-SNAPSHOT.jar /app/app-web/api-admin.jar
COPY api-cabin-floor/target/api-cabin-0.0.3-SNAPSHOT.jar /app/app-web/api-capin-floor.jar

ENTRYPOINT ["java", "-jar", "/app/app-web/api-admin.jar"]
ENTRYPOINT ["java", "-jar", "/app/app-web/api-capin-floor.jar"]