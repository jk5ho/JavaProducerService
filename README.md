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
curl -X GET \
  http://localhost:8081/demo/all \
  -H 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1aWQiOjEyMzQsInJvbGVzIjoiYWRtaW4td3JpdGUtYWxsLGFkbWluLXJlYWQtYWxsIiwicGxhdGZvcm1zIjoiYW0ifQ.p1_TzIeTiKsE21GCBwIoiIV9twFUj5jPQiBPGcTuWI1V57OQrTlZN-nO2JMnG1aBbPzq8sfUkCLde99CPOg8Ww' \
  -H 'Postman-Token: a68cbbf0-966a-4c5a-a9f2-97b7cdad00e2' \
  -H 'cache-control: no-cache'
```

### Output
Logger output will be in the form of ``#### -> Produce -> {url} -> and -> {button}``
