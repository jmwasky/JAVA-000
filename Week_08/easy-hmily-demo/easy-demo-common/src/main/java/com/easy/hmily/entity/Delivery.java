package com.easy.hmily.entity;

import lombok.Data;

/**
 * @author think
 * @date 2020/12/9
 */
@Data
public class Delivery implements java.io.Serializable{
    private Long id;
    private Long accountId;
    private String address;
    private Long createTime;
}
