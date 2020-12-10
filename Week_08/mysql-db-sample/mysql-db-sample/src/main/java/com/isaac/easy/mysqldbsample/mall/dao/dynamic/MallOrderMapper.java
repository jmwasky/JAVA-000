package com.isaac.easy.mysqldbsample.mall.dao.dynamic;

import com.isaac.easy.mysqldbsample.mall.module.MallOrder;
import com.isaac.easy.mysqldbsample.mall.module.MallOrderExample;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MallOrderMapper {
    @Update("update t_order set status = 1 where id = #{id}")
    int confirm( MallOrder order );

    @Update("update t_order set status = -1 where account_id= #{accountId}")
    int cancel( MallOrder order );
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int deleteByPrimaryKey( Long id );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int insert( MallOrder record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int insertSelective( MallOrder record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    List<MallOrder> selectByExample( MallOrderExample example );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    MallOrder selectByPrimaryKey( Long id );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int updateByPrimaryKeySelective( MallOrder record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int updateByPrimaryKey( MallOrder record );
}