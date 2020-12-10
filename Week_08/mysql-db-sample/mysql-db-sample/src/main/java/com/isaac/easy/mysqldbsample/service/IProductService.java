package com.isaac.easy.mysqldbsample.service;

import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.mall.module.MallProduct;
import org.dromara.hmily.annotation.Hmily;

/**
 * @author think
 * @date 2020/12/10
 */
public interface IProductService {
    @Hmily
    int tryProductFreeze( MallOrder order );
}
