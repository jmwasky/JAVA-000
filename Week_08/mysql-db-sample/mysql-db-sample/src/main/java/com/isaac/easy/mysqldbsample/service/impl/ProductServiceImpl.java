package com.isaac.easy.mysqldbsample.service.impl;

import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallProductMapper;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.mall.module.MallProduct;
import com.isaac.easy.mysqldbsample.service.IProductService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author think
 * @date 2020/12/10
 */
@Service
public class ProductServiceImpl implements IProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Resource
    private MallProductMapper mallProductMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirmProduct", cancelMethod = "cancelProduct")
    public int tryProductFreeze( MallOrder order ) {
        return mallProductMapper.updateTry(order);
    }
    public boolean confirmProduct(final MallOrder order) {
        LOGGER.info("============执行product confirm 接口===============");
        return mallProductMapper.confirm(order) > 0;
    }
    public boolean cancelProduct(final MallOrder order) {
        LOGGER.info("============执行product cancel 接口===============");
        return mallProductMapper.cancel(order) > 0;
    }
}
