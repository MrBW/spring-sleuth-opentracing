#!/bin/bash
echo Starting INSTANA AGENT
service instana-agent start
echo Starting Spring Boot App $1
java -jar $1
