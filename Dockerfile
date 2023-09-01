FROM openjdk:17
ADD /target/news-1.0-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]