# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Add a volume to reduce repeated Docker rebuilds
VOLUME /tmp

# Add the jar to the container
COPY target/jenkins-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]