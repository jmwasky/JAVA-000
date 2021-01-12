package com.isaac.easy.activemq.base;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liangchao
 * @date 2021/1/12
 */
public class Consumer extends MQBase{
    public String getMessage(Destination destination){
        try {
            MessageConsumer consumer = null;

            if(THREAD_LOCAL_CONSUER.get()!=null){
                consumer = THREAD_LOCAL_CONSUER.get();
            }else{
                consumer = session.createConsumer(destination);
                THREAD_LOCAL_CONSUER.set(consumer);
            }
            TextMessage msg = (TextMessage) consumer.receive();
            if(msg != null) {
                msg.acknowledge();
                System.out.println(Thread.currentThread().getName()+" Consumer msg:" + msg.getText());
            }
            return msg.getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return "";
    }
}
