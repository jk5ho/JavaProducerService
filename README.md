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
Send POST request with parameters _url_ and _button_ via POSTMAN or CURL

### Output
Logger output will be in the form of ``#### -> Produce -> {url} -> and -> {button}``
