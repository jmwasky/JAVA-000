package com.isaac.easy.mysqldbsample.service;

import com.isaac.easy.mysqldbsample.mall.module.MallAccount;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import org.dromara.hmily.annotation.Hmily;

import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
public interface IAccountService {
    @Hmily
    int tryAccountPayment(MallOrder order);
}
