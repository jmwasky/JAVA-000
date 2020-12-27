package com.easy.hmily.mapper;

import com.easy.hmily.entity.FxAccount;
import org.apache.ibatis.annotations.Select;

/**
 * @author think
 * @date 2020/12/27
 */
public interface FxAccountMapper {

    /**
     * select fx account by id
     * @param id the fx account id
     * @return the fx account info
     */
    @Select("Select id, account_id, create_time, amount, freeze, currency from t_fx_account where id = #{id}")
    FxAccount selectFxAccountById(Long id);
}
