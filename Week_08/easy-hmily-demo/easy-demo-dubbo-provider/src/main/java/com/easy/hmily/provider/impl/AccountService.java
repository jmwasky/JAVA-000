package com.easy.hmily.provider.impl;

import com.easy.hmily.api.IAccountService;
import com.easy.hmily.entity.Account;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;

/**
 * @author think
 * @date 2020/12/23
 */
@DubboService(version = "1.0.0", weight = 100)
public class AccountService implements IAccountService {

    @Override
    public Account findById( Integer id ) {
        return null;
    }

    @Override
    public Boolean update( Account account ) {
        return null;
    }
}
