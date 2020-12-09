package com.isaac.easy.mysqldbsample.service;

import cn.hutool.db.sql.Order;
import com.isaac.easy.mysqldbsample.mall.biz.OrderDTO;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;

import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
public interface IOrderService {
    /**
     * try 阶段
     * @param count
     * @param amount
     * @return
     */
    MallOrder tryPayOrder( Integer count, BigDecimal amount );
}
