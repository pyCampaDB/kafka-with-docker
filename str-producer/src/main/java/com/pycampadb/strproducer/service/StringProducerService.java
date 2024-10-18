package com.pycampadb.strproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StringProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message).whenComplete((result, ex) -> {
            if (ex!= null) log.error("Error to send the message: {}",ex.getMessage());
            log.info("The message was sent successfully: {}", result.getProducerRecord().value());
            log.info("Partition {}, Offset {}", result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
        });
    }
}
