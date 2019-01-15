## Assignment 1 - Producer
Spring Microservice-Kafka

### Setup
At project root directory:
```
mvn clean install
```

Ensure the _confluent-kafka-5.x_ is running:
```
docker-compose up
```

### Input
* Input is defined as the button pressed and the previous page url
* Send POST request with parameters __url__ and __button__ via POSTMAN or CURL:
```
GET /demo/all HTTP/1.1
Host: localhost:8081
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1aWQiOjEyMzQsInJvbGVzIjoiYWRtaW4td3JpdGUtYWxsLGFkbWluLXJlYWQtYWxsIiwicGxhdGZvcm1zIjoiYW0ifQ.p1_TzIeTiKsE21GCBwIoiIV9twFUj5jPQiBPGcTuWI1V57OQrTlZN-nO2JMnG1aBbPzq8sfUkCLde99CPOg8Ww
cache-control: no-cache
Postman-Token: 31dfc1f4-dca2-4d7b-99d3-01cff0d40221

```

### Output
Logger output will be in the form of ``#### -> Produce -> {url} -> and -> {button}``
