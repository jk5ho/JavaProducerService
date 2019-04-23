## Producer
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
curl -X POST \
  'http://localhost:8080/api/kafka/publish?url=www.urlTest.com&button=buttonTest' \
  -H 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1aWQiOjEyMzQsInJvbGVzIjoiYWRtaW4td3JpdGUtYWxsLGFkbWluLXJlYWQtYWxsIiwicGxhdGZvcm1zIjoiYW0ifQ.p1_TzIeTiKsE21GCBwIoiIV9twFUj5jPQiBPGcTuWI1V57OQrTlZN-nO2JMnG1aBbPzq8sfUkCLde99CPOg8Ww' \
  -H 'Postman-Token: 678f6b6d-449f-4852-aa38-ba7b15a02b58' \
  -H 'cache-control: no-cache'
```

### Output
Logger output will be in the form of ``#### -> Produce -> {url} -> and -> {button}``
