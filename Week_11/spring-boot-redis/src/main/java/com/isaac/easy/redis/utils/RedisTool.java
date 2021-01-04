package com.isaac.easy.redis.utils;

import com.isaac.easy.redis.entity.RedisLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.util.concurrent.TimeUnit;

/**
 * @author liangchao
 * @date 2021/1/4
 */
public class RedisTool {

    private static Logger logger = LoggerFactory.getLogger(RedisTool.class);

    /**
     * 获取分布式锁
     * @param redisTemplate
     * @param lock
     * @return
     */
    public static Boolean tryGetSetLock ( RedisTemplate redisTemplate, RedisLock lock ) {
        boolean result = false;
        boolean tryLock = redisTemplate.opsForValue().setIfAbsent(lock.getKey(), lock.getUniqueId());
        if (tryLock) {
            logger.info("-------try lock{}---------", tryLock);
            redisTemplate.expire(lock.getKey(), lock.getTimeOutSecond(), TimeUnit.SECONDS);
            result = true;
        }
        return result;
    }

    /**
     * 自增
     * @param key
     * @param redisTemplate
     * @return
     */
    public static Long getValueIncrement (String key, RedisTemplate redisTemplate, Long initialValue) {
        RedisAtomicLong incrementCounter;
        if (null == initialValue) {
            incrementCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        } else {
            incrementCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory(), initialValue);
        }
        Long increment = incrementCounter.incrementAndGet();
        if (increment < 0) {
            incrementCounter.set(0L);
            increment = 0L;
        }

        return increment;
    }

    /**
     * 自减
     * @param key
     * @param redisTemplate
     * @return
     */
    public static Long getValueDecrement (String key, RedisTemplate redisTemplate, Long initialValue) {
        RedisAtomicLong decrementCounter;

        if (null == initialValue) {
            decrementCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        } else {
            decrementCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory(), initialValue);
        }

        Long decrement = decrementCounter.decrementAndGet();
        if (decrement < 0) {
            decrementCounter.set(0L);
            decrement = 0L;
        }
        return decrement;
    }
}
