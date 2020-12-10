package com.isaac.easy.mysqldbsample.service.impl;

import com.isaac.easy.mysqldbsample.mall.biz.OrderDTO;
import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallOrderMapper;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.mall.module.MallProduct;
import com.isaac.easy.mysqldbsample.service.IOrderService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private MallOrderMapper mallOrderMapper;

    @Override
    public MallOrder tryPayOrder( Integer count, BigDecimal amount ) {

        MallOrder updateOrder = builderOrder(count, amount.longValue());
        mallOrderMapper.insertSelective(updateOrder);
        return updateOrder;
    }
    private MallOrder builderOrder ( Integer count, Long amount) {
        MallOrder order = new MallOrder();
        order.setAccountId(1L);
        order.setProductId(1L);
        order.setDeliveryId(1L);
        order.setCreateTime(System.currentTimeMillis());
        order.setConsumeCount(count);
        order.setTotalAmount(amount);
        order.setStatus(0);
        return order;
    }
}
