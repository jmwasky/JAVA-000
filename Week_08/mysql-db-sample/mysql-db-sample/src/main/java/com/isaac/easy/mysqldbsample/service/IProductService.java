package com.isaac.easy.mysqldbsample.service;

import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.mall.module.MallProduct;

/**
 * @author think
 * @date 2020/12/10
 */
public interface IProductService {
    int tryProductFreeze( MallOrder order );
}
