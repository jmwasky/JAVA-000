package com.isaac.easy.mysqldbsample.service.impl;

import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallProductMapper;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.mall.module.MallProduct;
import com.isaac.easy.mysqldbsample.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author think
 * @date 2020/12/10
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private MallProductMapper mallProductMapper;

    @Override
    public int tryProductFreeze( MallOrder order ) {
        return mallProductMapper.updateTry(order);
    }
}
