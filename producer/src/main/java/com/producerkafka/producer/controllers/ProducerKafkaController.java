package com.producerkafka.producer.controllers;

import com.producerkafka.producer.config.TemplateSendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ProducerKafkaController {
  private final TemplateSendMessage send;

  @GetMapping("send")
  public ResponseEntity<?> send(){
    send.sendMessage("Topic kafka - Encerra contas" + " Data: " + LocalDateTime.now());
    return ResponseEntity.ok().build();
  }
}
