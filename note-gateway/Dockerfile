FROM instana_base

COPY target/note-gateway.jar /usr/local/bin
WORKDIR /usr/local/bin

CMD ["/usr/local/bin/enable_instana.sh", "note-gateway.jar"]

EXPOSE 8090
