package com.isaac.scan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author isaac
 * @date 2020/11/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student2 {
    private int id;
    private String name;
    private int age;
    private String address;

}
