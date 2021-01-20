package io.kimmking.kmq.demo;

import io.kimmking.kmq.core.KmqBroker;
import io.kimmking.kmq.core.KmqConsumer;
import io.kimmking.kmq.core.KmqMessage;
import io.kimmking.kmq.core.KmqProducer;

import lombok.SneakyThrows;

public class KmqDemo {

    @SneakyThrows
    public static void main(String[] args) {

        String topic = "kk.test";
        String topic2 = "kk.test2";
        KmqBroker broker = new KmqBroker();
        broker.createTopic(topic);
        broker.createTopic(topic2);

        KmqConsumer consumer = broker.createConsumer();
        consumer.subscribe(topic);
        KmqConsumer consumer2 = broker.createConsumer();
        consumer2.subscribe(topic2);
        final boolean[] flag = new boolean[1];
        flag[0] = true;
        new Thread(() -> {
            while (flag[0]) {
                KmqMessage<Order> message = consumer.poll("test");
                if(null != message) {
                    System.out.println("consumer get body:" + message.getBody());
                }
            }
            System.out.println("程序退出。");
        }).start();
        new Thread(() -> {
            while (flag[0]) {
                KmqMessage<Order> message = consumer2.poll("testKey");
                if(null != message) {
                    System.out.println("consumer2 get body:" + message.getBody());
                }
            }
            System.out.println("程序退出。");
        }).start();

        KmqProducer producer = broker.createProducer();
        for (int i = 0; i < 10; i++) {
            Order order = new Order(1000L + i, System.currentTimeMillis(), "USD2CNY", 6.51d);
            producer.send(topic, new KmqMessage(null, order));
          //  producer.send(topic2, new KmqMessage(null, order));
        }
        Thread.sleep(500);
        System.out.println("点击任何键，发送一条消息；点击q或e，退出程序。");
        while (true) {
            char c = (char) System.in.read();
            if(c > 20) {
                System.out.println("input:" + c);
                Order order = new Order(100000L + c, System.currentTimeMillis(), "USD2CNY", 6.52d);
                KmqMessage kmqMessage = new KmqMessage(null, order);
                producer.send(topic, kmqMessage );
                producer.send(topic2, new KmqMessage(null, order));
                producer.send(topic2, new KmqMessage(null, order));
            }

            if( c == 'q' || c == 'e') break;
        }

        flag[0] = false;
        while (true) {
            KmqMessage<Order> message = consumer2.poll("testKey2");
            if(null != message) {
                System.out.println("testKey2 get body:" + message.getBody());
            }
        }
    }
}
