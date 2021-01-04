package com.isaac.easy.redis.utils;

import com.isaac.easy.redis.entity.RedisLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

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
}
