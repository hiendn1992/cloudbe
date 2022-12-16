FROM openjdk:8-jre-alpine
RUN mkdir -p /usr/cloudbe
COPY /target/cloudbe-0.0.1-SNAPSHOT.jar /usr/cloudbe
WORKDIR /usr/cloudbe
EXPOSE 8080
CMD ["java", "-jar", "cloudbe-0.0.1-SNAPSHOT.jar"]