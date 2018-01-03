FROM instana_base

COPY target/zipkin.jar /usr/local/bin
WORKDIR /usr/local/bin

CMD ["/usr/local/bin/enable_instana.sh", "zipkin.jar"]

EXPOSE 9411
