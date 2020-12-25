package com.easy.hmily.api;

import com.easy.hmily.entity.Account;
import org.dromara.hmily.annotation.Hmily;

/**
 * @author think
 * @date 2020/12/23
 */
public interface IAccountService {
    @Hmily
    Account findById(Integer id);
    @Hmily
    Boolean update(Account account);
}
