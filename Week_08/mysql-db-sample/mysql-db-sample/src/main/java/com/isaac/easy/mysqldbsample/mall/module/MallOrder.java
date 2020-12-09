package com.isaac.easy.mysqldbsample.mall.module;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_order
 */
public class MallOrder {
    /**
     * Database Column Remarks:
     *   主键ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   用户ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.account_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    private Long accountId;

    /**
     * Database Column Remarks:
     *   产品ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.product_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    private Long productId;

    /**
     * Database Column Remarks:
     *   消费数目
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.consume_count
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    private Integer consumeCount;

    /**
     * Database Column Remarks:
     *   消费总额
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.total_amount
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    private Long totalAmount;

    /**
     * Database Column Remarks:
     *   配送信息ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.delivery_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    private Long deliveryId;

    /**
     * Database Column Remarks:
     *   订单支付状态：1已支付，2未支付
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.status
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order.create_time
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    private Long createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.id
     *
     * @return the value of t_order.id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.id
     *
     * @param id the value for t_order.id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.account_id
     *
     * @return the value of t_order.account_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.account_id
     *
     * @param accountId the value for t_order.account_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.product_id
     *
     * @return the value of t_order.product_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.product_id
     *
     * @param productId the value for t_order.product_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.consume_count
     *
     * @return the value of t_order.consume_count
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public Integer getConsumeCount() {
        return consumeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.consume_count
     *
     * @param consumeCount the value for t_order.consume_count
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public void setConsumeCount(Integer consumeCount) {
        this.consumeCount = consumeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.total_amount
     *
     * @return the value of t_order.total_amount
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public Long getTotalAmount() {
        return totalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.total_amount
     *
     * @param totalAmount the value for t_order.total_amount
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.delivery_id
     *
     * @return the value of t_order.delivery_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public Long getDeliveryId() {
        return deliveryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.delivery_id
     *
     * @param deliveryId the value for t_order.delivery_id
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.status
     *
     * @return the value of t_order.status
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.status
     *
     * @param status the value for t_order.status
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order.create_time
     *
     * @return the value of t_order.create_time
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order.create_time
     *
     * @param createTime the value for t_order.create_time
     *
     * @mbg.generated Wed Dec 09 23:14:56 CST 2020
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}