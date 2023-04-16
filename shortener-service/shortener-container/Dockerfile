FROM maven:3.8.5-eclipse-temurin-17
EXPOSE 80
WORKDIR /applications
COPY target/shortener-container-1.0-SNAPSHOT.jar /applications/shortener-container.jar
ENTRYPOINT ["java","-jar", "shortener-container.jar"]