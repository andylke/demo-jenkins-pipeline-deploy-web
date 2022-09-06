package com.github.andylke.demo.user;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserRequestListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserRequestListener.class);

  @KafkaListener(topics = "demo-jenkins-pipeline-deploy-web.user-request")
  public void receive(String record) throws InterruptedException {
    LOGGER.info("Received '{}' at '{}'", record, LocalDateTime.now());
  }
}
