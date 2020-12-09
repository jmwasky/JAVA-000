package com.isaac.easy.mysqldbsample.service;

import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
public interface IPaymentService {

    /**
     *
     * @param count
     * @param amount
     * @return
     */
    boolean payOrder( Integer count, BigDecimal amount);
    /**
     *
     * @param count
     * @param amount
     * @return
     */
    boolean payOrderWithException( Integer count, BigDecimal amount);
}
