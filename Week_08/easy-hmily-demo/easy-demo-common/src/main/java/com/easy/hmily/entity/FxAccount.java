package com.easy.hmily.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author think
 * @date 2020/12/27
 */
@Data
public class FxAccount implements Serializable {
    private static final long serialVersionUID = 11849676368907419L;
    private Long id;
    private Long accountId;
    private Long createTime;
    private Double amount;
    private Double freeze;
    private String currency;
}
