package io.kimmking.kmq.core;

import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class Kmq {

    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        //this.queue = new LinkedBlockingQueue(capacity);
        this.queue = new EasyArrayQueue(capacity);
    }

    private String topic;

    private int capacity;

    //private LinkedBlockingQueue<KmqMessage> queue;
    private EasyArrayQueue<KmqMessage> queue;

    public boolean send(KmqMessage message) {
        return queue.offer(message);
    }

    public KmqMessage poll() {
        return queue.poll();
    }

    /*public KmqMessage poll(String consumerKey) {
        return queue.poll(consumerKey);
    }*/

    @SneakyThrows
    public KmqMessage poll(long timeout) {
        return queue.poll(timeout, TimeUnit.MILLISECONDS);
    }

}
