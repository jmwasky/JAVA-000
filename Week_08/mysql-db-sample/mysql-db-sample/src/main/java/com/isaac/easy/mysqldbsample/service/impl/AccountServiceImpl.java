package com.isaac.easy.mysqldbsample.service.impl;

import com.isaac.easy.mysqldbsample.mall.biz.AccountDTO;
import com.isaac.easy.mysqldbsample.mall.dao.dynamic.MallAccountMapper;
import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.service.IAccountService;
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
public class AccountServiceImpl implements IAccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private MallAccountMapper mallAccountMapper;
    @Override
    @HmilyTCC(confirmMethod = "confirmAccount", cancelMethod = "cancelAccount")
    public int tryAccountPayment( MallOrder order ) {
        return mallAccountMapper.updateTry(order);
    }
    public boolean confirmAccount(final MallOrder order) {
        LOGGER.info("============执行accont confirm 接口===============");
        return true;
    }
    public boolean cancelAccount(final MallOrder order) {
        LOGGER.info("============执行accont cancel 接口===============");
        return mallAccountMapper.cancel(order) > 0;
    }
}
