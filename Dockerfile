FROM openjdk:17-jdk
RUN groupadd -r spring && adduser -r spring -g spring
USER spring:spring

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]