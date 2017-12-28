FROM openjdk:8

COPY target/note-app.jar /usr/local/bin
WORKDIR /usr/local/bin

CMD ["java", "-jar", "note-app.jar"]

EXPOSE 8080