package com.isaac.easy.mysqldbsample.mall.dao.dynamic;

import com.isaac.easy.mysqldbsample.mall.module.MallAccount;
import com.isaac.easy.mysqldbsample.mall.module.MallAccountExample;

import java.util.List;

public interface MallAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int deleteByPrimaryKey( Long id );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int insert( MallAccount record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int insertSelective( MallAccount record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    List<MallAccount> selectByExample( MallAccountExample example );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    MallAccount selectByPrimaryKey( Long id );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int updateByPrimaryKeySelective( MallAccount record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int updateByPrimaryKey( MallAccount record );
}