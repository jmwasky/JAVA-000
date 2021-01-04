package com.isaac.easy;

import com.isaac.easy.redis.RunApplication;
import com.isaac.easy.redis.entity.RedisLock;
import com.isaac.easy.redis.utils.RedisTool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author think
 * @date 2021/1/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApplication.class)
public class TestRedis {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

   @Resource(name="redisTemplate")
   private SetOperations<String, String> setOperations;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testLock() throws Exception {
        RedisLock lock = new RedisLock("lock", "uuid", 300L);
        boolean tryLock = RedisTool.tryGetSetLock(stringRedisTemplate, lock);
        if (tryLock) {
            Assert.assertTrue("Can not get lock!", tryLock);
        } else {
            lock.setUniqueId("second");
            boolean secondLock = RedisTool.tryGetSetLock(stringRedisTemplate, lock);
            Assert.assertTrue("Have been lock!", !secondLock);
        }
    }

}
