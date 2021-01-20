package io.kimmking.kmq.core;

import lombok.SneakyThrows;

import java.util.AbstractQueue;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author think
 * @date 2021/1/18
 */
public class EasyArrayQueue<E> extends AbstractQueue<E> {

    private final E[] arrayQueue;

    private AtomicInteger DATA_OFFSET = new AtomicInteger(0);

    private Map<String, Integer> CONSUMER_OFFSET_MAP = new ConcurrentHashMap<String, Integer>();

    /**
     * Lock used for all public operations
     */
    private final ReentrantLock lock;
    /**
     * Condition for blocking when empty
     */
    private final Condition notEmpty;

    private final String DEFAULT_CONSUMER_KEY = "default";

    public EasyArrayQueue( int capacity) {
        this.arrayQueue = (E[]) new Object[capacity];
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
    }

    @Override
    public Iterator<E> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public int size() {
        return this.arrayQueue.length;
    }

    @SneakyThrows
    @Override
    public boolean offer( E e ) {
        int offset = DATA_OFFSET.get();
        if (null == e) {
            throw new NullPointerException();
        }
        if (offset == this.size()-1) {
            throw new IllegalAccessException("The queue is full!");
        }
        this.arrayQueue[offset] = e;
        DATA_OFFSET.addAndGet(1);
        return true;
    }

    @Override
    public E poll() {
        return poll(DEFAULT_CONSUMER_KEY);
    }

    /**
     * array poll
     * @param consumerKey
     * @return
     */
    private E poll(String consumerKey) {
        E result = null;
        if (null == consumerKey) {
            consumerKey = DEFAULT_CONSUMER_KEY;
        }
        if (CONSUMER_OFFSET_MAP.containsKey(consumerKey)) {
            int offset = CONSUMER_OFFSET_MAP.get(consumerKey) + 1;
            if (offset >= 0 && offset <= DATA_OFFSET.get()) {
                result = this.arrayQueue[offset];
                if (null != result) {
                    CONSUMER_OFFSET_MAP.put(consumerKey, offset);
                }
            }
        } else {
            CONSUMER_OFFSET_MAP.put(consumerKey, 0);
            result = poll(consumerKey);
        }
        return result;
    }

    /**
     *
     * @param consumerKey
     * @param timeout
     * @param timeUnit
     * @return
     */
    public E poll( String consumerKey, Long timeout, TimeUnit timeUnit ) throws InterruptedException {
        long nanos = timeUnit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        E result;
        lock.lockInterruptibly();
        try {
            while ( (result = poll(consumerKey)) == null && nanos > 0) {
                nanos = notEmpty.awaitNanos(nanos);
            }
        } finally {
            lock.unlock();
        }
        return result;
    }
    public E poll(Long timeout, TimeUnit timeUnit ) throws InterruptedException {
        return poll(null, timeout, timeUnit);
    }

    @Override
    public E peek() {
        return null;
    }
}
