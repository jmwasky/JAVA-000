package com.isaac.easy.mysqldbsample.controller;

import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallAccountMapper;
import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallOrderMapper;
import com.isaac.easy.mysqldbsample.mall.dao.secondary.MallOrderMapper2;
import com.isaac.easy.mysqldbsample.mall.module.MallAccount;
import com.isaac.easy.mysqldbsample.mall.module.MallAccountExample;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.mall.module.MallOrderExample;
import com.isaac.easy.mysqldbsample.service.IOrderService;
import com.isaac.easy.mysqldbsample.service.IPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 *
 * @author liangchao
 */
@RestController
@RequestMapping("/mall")
public class MallController {

    @Resource
    private IPaymentService paymentService;
    @Resource
    private IOrderService orderService;

    @GetMapping("/ping")
    public String ping(){

        return "Ping mall!";
    }

    @PostMapping("/payOrder")
    public int payOrder( Integer count, BigDecimal amount ) {
        MallOrder order = orderService.tryPayOrder(count, amount);
        paymentService.payOrder(order);
        return 1;
    }
    @PostMapping("/payOrderWithException")
    public int payOrderWithException( Integer count, BigDecimal amount ) {
        return 1;
    }

}
