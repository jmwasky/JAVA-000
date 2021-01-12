package com.isaac.easy.activemq.base;

import javax.jms.Destination;
import javax.jms.JMSException;
import java.util.Queue;
import java.util.Random;

/**
 * @author think
 * @date 2021/1/11
 */
public class TestProducerMQ {
    public static void main(String[] args){
        //producerQueueTest();
        producerTopicTest();
    }

    private static void producerQueueTest() {
        Producer producer = new Producer();
        producer.init();
        Destination queue = null;
        try {
            queue = producer.session.createQueue("test");
        } catch (JMSException e) {
            e.printStackTrace();
        }
        producer.sendMessage(queue, "liangchao" + new Random().nextInt());
        producer.destroy();
    }
    private static void producerTopicTest() {
        Producer producer = new Producer();
        producer.init();
        Destination queue = null;
        try {
            queue = producer.session.createTopic("testTopic");
        } catch (JMSException e) {
            e.printStackTrace();
        }
        producer.sendMessage(queue, "liangchao" + new Random().nextInt());
        producer.destroy();
    }

}
