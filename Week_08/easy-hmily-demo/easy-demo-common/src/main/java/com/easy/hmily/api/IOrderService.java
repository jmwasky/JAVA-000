package com.easy.hmily.api;

import com.easy.hmily.entity.Order;
import org.dromara.hmily.annotation.Hmily;

/**
 * @author think
 * @date 2020/12/23
 */
public interface IOrderService {
    @Hmily
    Order findById( Integer id);
    @Hmily
    Order save(Order order);
    @Hmily
    int udpate(Order order);

}
