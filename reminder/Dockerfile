FROM instana_base

COPY target/reminder.jar /usr/local/bin
WORKDIR /usr/local/bin

EXPOSE 8099

CMD ["/usr/local/bin/enable_instana.sh", "reminder.jar"]
