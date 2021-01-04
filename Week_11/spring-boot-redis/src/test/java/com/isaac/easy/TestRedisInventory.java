package com.isaac.easy;

import com.isaac.easy.redis.RunApplication;
import com.isaac.easy.redis.entity.RedisLock;
import com.isaac.easy.redis.utils.RedisTool;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import sun.net.www.http.HttpClient;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

/**
 * @author think
 * @date 2021/1/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApplication.class)
public class TestRedisInventory {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testCounter() throws Exception {
        String counter = "myCount";
        Long value = RedisTool.getValueIncrement(counter, redisTemplate, 0L);
        Assert.assertTrue("Increment value not true->" + value, value==1L);
        value = RedisTool.getValueDecrement(counter, redisTemplate, null);
        Assert.assertTrue("Decrement value not true->" + value, value==0L);

        value = RedisTool.getValueDecrement(counter, redisTemplate, 0L);
        Assert.assertTrue("Increment2 value not true->" + value, value==0L);

        value = RedisTool.getValueDecrement(counter, redisTemplate, 1L);
        Assert.assertTrue("Increment3 value not true->" + value, value==0L);

        value = RedisTool.getValueDecrement(counter, redisTemplate, 2L);
        Assert.assertTrue("Increment4 value not true->" + value, value==1L);
    }



}
