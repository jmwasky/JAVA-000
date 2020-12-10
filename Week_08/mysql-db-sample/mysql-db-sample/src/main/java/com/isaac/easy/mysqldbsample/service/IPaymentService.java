package com.isaac.easy.mysqldbsample.service;

import com.isaac.easy.mysqldbsample.mall.module.MallOrder;

import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
public interface IPaymentService {

    /**
     *
     * @param order
     * @return
     */
    boolean payOrder( MallOrder order );
    /**
     *
     * @param count
     * @param amount
     * @return
     */
    boolean payOrderWithException( Integer count, BigDecimal amount);
}
