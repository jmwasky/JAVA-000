package com.isaac.easy.mysqldbsample.mall.dao.master;

import com.isaac.easy.mysqldbsample.mall.module.MallDelivery;
import com.isaac.easy.mysqldbsample.mall.module.MallDeliveryExample;
import java.util.List;

public interface MallDeliveryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_delivery
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int deleteByPrimaryKey( Long id );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_delivery
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int insert( MallDelivery record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_delivery
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int insertSelective( MallDelivery record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_delivery
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    List<MallDelivery> selectByExample( MallDeliveryExample example );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_delivery
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    MallDelivery selectByPrimaryKey( Long id );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_delivery
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int updateByPrimaryKeySelective( MallDelivery record );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_delivery
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    int updateByPrimaryKey( MallDelivery record );
}