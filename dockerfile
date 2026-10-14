FROM openjdk:25-rc
COPY target/laboratorio_1_aaron_rivera-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java","-jar","app.jar"]