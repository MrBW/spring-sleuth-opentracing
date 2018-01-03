FROM instana_base

COPY target/note-app.jar /usr/local/bin
WORKDIR /usr/local/bin

CMD ["/usr/local/bin/enable_instana.sh", "note-app.jar"]

EXPOSE 8080
