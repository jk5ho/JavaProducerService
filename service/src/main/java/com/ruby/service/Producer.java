package com.ruby.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ruby.model.User;

@Service
@Slf4j
public class Producer {

  private static final String TOPIC = "users";

  @Autowired
  private KafkaTemplate<String, User> kafkaTemplate;

  public void sendMessage(String url, String button) {
    User userMessage = new User(url, button);
    log.debug("#### -> Produce -> {} -> and -> {}", url, button);
    this.kafkaTemplate.send(TOPIC, userMessage);
  }

}