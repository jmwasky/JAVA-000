package com.isaac.easy.mysqldbsample.service.impl;

import com.isaac.easy.mysqldbsample.mall.biz.OrderDTO;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.service.IAccountService;
import com.isaac.easy.mysqldbsample.service.IOrderService;
import com.isaac.easy.mysqldbsample.service.IPaymentService;
import com.isaac.easy.mysqldbsample.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Resource
    private IOrderService orderService;
    @Resource
    private IAccountService accountService;
    @Resource
    private IProductService productService;

    @Override
    public boolean payOrder( Integer count, BigDecimal amount ) {
        // 新建订单
        MallOrder order = orderService.tryPayOrder(count, amount);
        // 冻结用户金额
        accountService.tryAccountPayment(order);
        // 冻结库存
        productService.tryProductFreeze(order);
        return true;
    }

    @Override
    public boolean payOrderWithException( Integer count, BigDecimal amount ) {
        return false;
    }

}
