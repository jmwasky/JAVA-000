package com.isaac.easy.redis.controller;

import com.isaac.easy.redis.utils.RedisTool;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 *
 * @author liangchao
 */
@RestController
@RequestMapping("/mall")
public class MallController {

    private static final String INVENTORY_COUNTER_KEY = "inventoryCounterKey";

    @Resource
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init () {
        redisTemplate.opsForValue().setIfAbsent(INVENTORY_COUNTER_KEY, 0L);
    }

    @GetMapping("/ping")
    public String ping(){
        return "Ping mall!";
    }

    @PostMapping("/producer")
    public Long producer() {
        Long value = RedisTool.getValueIncrement(INVENTORY_COUNTER_KEY, redisTemplate, null);
        return value;
    }

    @PostMapping("/consumer")
    public Long consumer() {
        Long value = RedisTool.getValueDecrement(INVENTORY_COUNTER_KEY, redisTemplate, null);
        return value;
    }

}
