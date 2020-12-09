package com.isaac.easy.mysqldbsample.mall.biz;

import io.swagger.models.auth.In;

import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
public class AccountDTO {
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }
}
