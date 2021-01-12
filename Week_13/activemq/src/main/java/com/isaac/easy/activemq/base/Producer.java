package com.isaac.easy.activemq.base;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author think
 * @date 2021/1/11
 */
public class Producer extends MQBase{
    public void sendMessage(Destination distination, String mqMsg){
        try {
            //消息生产者
            MessageProducer messageProducer = null;
            if(THREAD_LOCAL_PRODUCER.get()!=null){
                messageProducer = THREAD_LOCAL_PRODUCER.get();
            }else{
                messageProducer = session.createProducer(distination);
                THREAD_LOCAL_PRODUCER.set(messageProducer);
            }
            //int num = count.getAndIncrement();
            //创建一条消息
            String msgStr = Thread.currentThread().getName() + "producer: 生产者,msg:"+mqMsg;
            TextMessage msg = session.createTextMessage(msgStr);
            System.out.println(msgStr);
            //发送消息
            messageProducer.send(msg);
            //提交事务
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
