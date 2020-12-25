package com.easy.hmily.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author think
 * @date 2020/12/9
 */
@Data
@ToString
public class Product implements java.io.Serializable{
    private Long id;
    private String name;
    private String description;
    private Long freeze_count;
    private Long total;
    private Long createTime;
}
