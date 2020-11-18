package com.isaac.spring.boot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.easy.auto.school.klass")
public class Klass { 
    
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
