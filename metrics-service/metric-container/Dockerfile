FROM maven:3.8.5-eclipse-temurin-17
EXPOSE 81
WORKDIR /applications
COPY target/metric-container-1.0-SNAPSHOT.jar /applications/metric-container.jar
ENTRYPOINT ["java","-jar", "metric-container.jar"]