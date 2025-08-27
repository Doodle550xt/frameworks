FROM azul/zulu-openjdk:24
COPY target/holamundo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
