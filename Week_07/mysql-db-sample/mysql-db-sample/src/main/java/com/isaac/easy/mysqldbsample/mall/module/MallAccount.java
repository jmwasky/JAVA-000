package com.isaac.easy.mysqldbsample.mall.module;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_account
 */
public class MallAccount {
    /**
     * Database Column Remarks:
     *   ����ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_account.id
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   �û���
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_account.account_name
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    private String accountName;

    /**
     * Database Column Remarks:
     *   ����
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_account.salt_password
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    private String saltPassword;

    /**
     * Database Column Remarks:
     *   ����ʱ��
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_account.create_time
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    private Long createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_account.id
     *
     * @return the value of t_account.id
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_account.id
     *
     * @param id the value for t_account.id
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_account.account_name
     *
     * @return the value of t_account.account_name
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_account.account_name
     *
     * @param accountName the value for t_account.account_name
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_account.salt_password
     *
     * @return the value of t_account.salt_password
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    public String getSaltPassword() {
        return saltPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_account.salt_password
     *
     * @param saltPassword the value for t_account.salt_password
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    public void setSaltPassword(String saltPassword) {
        this.saltPassword = saltPassword == null ? null : saltPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_account.create_time
     *
     * @return the value of t_account.create_time
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_account.create_time
     *
     * @param createTime the value for t_account.create_time
     *
     * @mbg.generated Tue Dec 01 17:10:55 CST 2020
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}