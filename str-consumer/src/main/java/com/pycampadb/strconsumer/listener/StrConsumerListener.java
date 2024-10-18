package com.pycampadb.strconsumer.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {
    @KafkaListener(groupId = "group-1",
            topicPartitions = @TopicPartition(topic = "str-topic", partitions = {"0"}),
            containerFactory = "validMessageContainerFactory"
    )
    public void listener1(String message){
        log.info("LISTENER1 ::: Receiving a message {}", message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = @TopicPartition(topic = "str-topic", partitions = {"1"}),
            containerFactory = "validMessageContainerFactory"
    )
    public void listener2(String message){
        log.info("LISTENER2 ::: Receiving a message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void listener3(String message){
        log.info("LISTENER3 ::: Receiving a message {}", message);
    }

    /*@KafkaListener(groupId = "group-4", topics = "str-topic", containerFactory = "strContainerFactory")
    public void listener4(String message){
        log.info("Received a message: {}", message);
        log.info("LISTENER4 ::: Receiving a message {}", message);
    }*/
}
