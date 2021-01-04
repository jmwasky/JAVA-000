package com.isaac.easy.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


/**
 *
 * @author liangchao
 */
@RestController
@RequestMapping("/mall")
public class MallController {



    @GetMapping("/ping")
    public String ping(){

        return "Ping mall!";
    }

    @PostMapping("/test")
    public int test( Integer count, BigDecimal amount ) {

        return 1;
    }

}
