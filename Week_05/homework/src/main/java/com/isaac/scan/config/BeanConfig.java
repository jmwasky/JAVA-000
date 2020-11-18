package com.isaac.scan.config;

import com.isaac.scan.Student3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author think
 * @date 2020/11/15
 */
@Configuration
public class BeanConfig {
    @Bean(name="student3")
    public Student3 getStudent3() {
        return new Student3(12, "bean3", 12, "address");
    }
}
