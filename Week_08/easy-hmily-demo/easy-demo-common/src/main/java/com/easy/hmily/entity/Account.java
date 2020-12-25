package com.easy.hmily.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author think
 * @date 2020/12/9
 */
@Data
@ToString
public class Account implements java.io.Serializable{
    private Long id;
    private String accountName;
    private String saltPassword;
    private Long amount;
    private Long createTime;
}
