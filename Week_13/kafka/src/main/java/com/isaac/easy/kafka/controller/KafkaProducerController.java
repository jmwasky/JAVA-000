package com.isaac.easy.kafka.controller;

import com.isaac.easy.kafka.base.KafkaProducer;
import com.shsnc.common.model.kafkaService.FtpMsg;
import com.shsnc.common.utils.JsonUtils;
import com.shsnc.gateway.kafka.producer.GatewayProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;


/**
 * @author liangchao
 * @data on 2018/03/27
 */
@Slf4j
@RestController
@Component
@RequestMapping("/kafkaService")
public class KafkaProducerController {

    @Resource
    private KafkaProducer producer;

    @GetMapping(value="/ping")
    public String ping() {
        return "Ping kafkaService ok!";
    }

    /**
     * kafka producer
     * @param headers
     * @param body
     * @return
     */
    @PostMapping(value="/sendFileText")
    public String sendFileText(@RequestHeader Map<String, String> headers, @RequestBody String body) {
        String topic = headers.get("topic");
        String returnValue = "0";
        if (StringUtils.isNotEmpty(body)) {
            returnValue = producer.sendMessage(topic, body);
        }
        return returnValue;
    }

}
