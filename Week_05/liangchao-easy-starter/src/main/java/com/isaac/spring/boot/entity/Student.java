package com.isaac.spring.boot.entity;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author isaac
 * @date 2020/11/15
 */
@ConfigurationProperties(prefix = "spring.easy.auto.student")
@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private int age;
    private String address;

}
