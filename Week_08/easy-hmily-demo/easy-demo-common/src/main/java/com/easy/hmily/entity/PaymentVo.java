package com.easy.hmily.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author think
 * @date 2020/12/23
 */
@Data
@ToString
public class PaymentVo implements java.io.Serializable{
    private Account account;
    private Order order;
}
