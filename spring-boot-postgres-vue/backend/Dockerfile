FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/app-1.0.jar /app/app.jar
EXPOSE 2000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]
