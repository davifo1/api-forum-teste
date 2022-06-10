FROM openjdk:17-jdk
VOLUME /tmp
RUN groupadd -r spring && adduser -r spring -g spring
USER spring:spring

HEALTHCHECK --interval=5m --timeout=3s CMD curl -f http://localhost:8080/actuator/health/ || exit 1

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]