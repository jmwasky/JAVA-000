package com.isaac.easy.mysqldbsample.service.impl;

import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallAccountMapper;
import com.isaac.easy.mysqldbsample.mall.module.MallAccount;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author think
 * @date 2020/12/10
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private MallAccountMapper mallAccountMapper;
    @Override
    public int tryAccountPayment( MallOrder order ) {
        return mallAccountMapper.updateTry(order);
    }

}
