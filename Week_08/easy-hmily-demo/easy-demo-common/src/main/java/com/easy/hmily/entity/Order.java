package com.easy.hmily.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author think
 * @date 2020/12/9
 */
@Data
@ToString
public class Order implements java.io.Serializable{
    private Long id;
    private Long accountId;
    private Long productId;
    private Long consumeCount;
    private Long totalAmount;
    private Long deliveryId;
    private int status;
    private Long createTime;
}
