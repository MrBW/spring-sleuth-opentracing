# spring-sleuth-opentracing
![Travis build](https://travis-ci.org/MrBW/spring-sleuth-opentracing.svg?branch=master) [![codecov](https://codecov.io/gh/MrBW/spring-sleuth-opentracing/branch/master/graph/badge.svg)](https://codecov.io/gh/MrBW/spring-sleuth-opentracing)<br>
Spring Sleuth &amp; OpenTracing demo

## Architecture
### - draft -
![Architecture](/docs/NoteApp.png)

## Endpoints
### ZipKin Server
http://localhost:9411

### Note Gateway
#### Notes
- GET http://localhost:8090/notes
- GET http://localhost:8090/notes/{id}
- DELETE http://localhost:8090/notes/{id}
- POST http://localhost:8090/notes
with body:
```
{
    "noteMessage": "My Message"
}
```
#### Reminders
- GET http://localhost:8090/reminders
- GET http://localhost:8090/reminders/{id}
- DELETE http://localhost:8090/reminders/{id}
- POST http://localhost:8090/reminders
with body:
```
{
    tbd
}
```

### Note App
- GET http://localhost:8080/notes
- GET http://localhost:8080/notes/{id}
- DELETE http://localhost:8080/notes/{id}
- POST http://localhost:8080/notes
with body:
```
{
    "noteMessage": "My Message"
}
```

## Start using docker-compose
* create ```instana.key```file under ```/docker_base_image/instana.key``` and paste your personal INSTANA agent key
* build all projects ```$ ./mvnw clean package```
* start up: ```$ docker-compose up --build```
