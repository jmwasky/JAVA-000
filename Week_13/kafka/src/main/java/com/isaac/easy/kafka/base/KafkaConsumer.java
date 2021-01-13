package com.isaac.easy.kafka.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author think
 * @date 2021/1/13
 */
@Component
public class KafkaConsumer {
    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "${server.kafkaTopic}",group = "${spring.kafka.consumer.group-id}")
    public void receiveMsg(String message, Acknowledgment ack) {
        handleMsg(message, ack);
    }

    public void handleMsg(String message, Acknowledgment ack) {
        try {
            LOGGER.info(message);
            ack.acknwledge();
        } catch (Exception e) {

        } finally {

        }
    }
}
