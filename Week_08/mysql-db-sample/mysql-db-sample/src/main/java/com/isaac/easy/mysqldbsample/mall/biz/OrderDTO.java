package com.isaac.easy.mysqldbsample.mall.biz;

import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
public class OrderDTO {
    private Integer count;
    private BigDecimal amount;

    public Integer getCount() {
        return count;
    }

    public void setCount( Integer count ) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }
}
