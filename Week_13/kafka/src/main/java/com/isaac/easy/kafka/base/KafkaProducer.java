package com.isaac.easy.kafka.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author think
 * @date 2021/1/13
 */
@Component
public class KafkaProducer {
    private static Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Resource
    private KafkaTemplate<Object, String> kafkaTemplate;

    @Value("${server.kafkaTopic}")
    private String defaultTopic;

    /**
     *
     * @param topic
     * @param message
     * @return
     */
    public String sendMessage (String topic, String message) {
        String returnValue = "200";
        LOGGER.info("Sent message [{}] to [{}]",message, topic);
        if (StringUtils.isNotEmpty(message)) {
            topic = StringUtils.defaultString(topic, defaultTopic);
            kafkaTemplate.send(topic, message);
        } else {
            returnValue = "message is empty!";
            LOGGER.error("Sent message [{}] to [{}]",message, topic);
        }
        return returnValue;
    }
}
