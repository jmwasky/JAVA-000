package com.easy.hmily.provider.impl;

import com.easy.hmily.api.IOrderService;
import com.easy.hmily.entity.Order;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author think
 * @date 2020/12/23
 */
@DubboService(version = "1.0.0", weight = 100)
public class OrderService implements IOrderService {
    @Override
    public Order findById( Integer id ) {
        return createOrder();
    }

    @Override
    public Order save( Order order ) {
        return null;
    }

    @Override
    public int udpate( Order order ) {
        return 0;
    }

    private Order createOrder () {
        Order order = new Order();
        order.setId(1L);
        order.setAccountId(1L);
        return  order;
    }
}
