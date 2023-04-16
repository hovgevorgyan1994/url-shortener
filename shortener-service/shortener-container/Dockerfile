FROM openjdk:17
EXPOSE 8888
WORKDIR /applications
COPY target/shortener-container-1.0-SNAPSHOT.jar /applications/shortener-container.jar
ENTRYPOINT ["java","-jar", "shortener-container.jar"]