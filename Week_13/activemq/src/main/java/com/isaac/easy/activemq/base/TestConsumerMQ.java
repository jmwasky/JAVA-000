package com.isaac.easy.activemq.base;

import org.springframework.util.StringUtils;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.print.attribute.standard.Destination;

/**
 * @author think
 * @date 2021/1/11
 */
public class TestConsumerMQ {
    public static void main(String[] args){
        //consumerQueueTest();
        // 只会接受最新插入的消息
        consumerTopicTest();
    }
    private static void consumerQueueTest() {
        Consumer consumer = new Consumer();
        consumer.init();
        Queue destination = null;
        try {
            destination = consumer.session.createQueue("test");
            while (true) {
                String result = consumer.getMessage(destination);
                System.out.println("done---------");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    private static void consumerTopicTest() {
        Consumer consumer = new Consumer();
        consumer.init();
        Topic destination = null;
        try {
            destination = consumer.session.createTopic("testTopic");
            while (true) {
                String result = consumer.getMessage(destination);
                System.out.println("done---------");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
