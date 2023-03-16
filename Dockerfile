FROM amazoncorretto:8
MAINTAINER hector
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio-app.jar
ENTRYPOINT ["java","-jar","/portfolio-app.jar"]
