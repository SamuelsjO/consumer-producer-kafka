package com.producerkafka.producer.config;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@RequiredArgsConstructor
public class TemplateSendMessage {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String msg){
    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic-1", msg);

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

      @Override
      public void onSuccess(SendResult<String, String> result) {
        System.out.println(("Sent message=[" + msg + "] with offset=["
            + result.getRecordMetadata().offset() + "]"));
      }

      @Override
      public void onFailure(Throwable ex) {
        System.out.println("Unable to send message=["
            + msg + "] due to : " + ex.getMessage());
      }
    });
  }
}
