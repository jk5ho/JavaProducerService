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
Input is defined as the button pressed and the previous page url
Send POST request with parameters __url__ and __button__ via POSTMAN or CURL

### Output
Logger output will be in the form of ``#### -> Produce -> {url} -> and -> {button}``
