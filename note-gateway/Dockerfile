FROM openjdk:8

COPY target/note-gateway.jar /usr/local/bin
WORKDIR /usr/local/bin

CMD ["java", "-jar", "note-gateway.jar"]

EXPOSE 8090