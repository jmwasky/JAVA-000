package com.isaac.spring.boot.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.Resource;

@Data
@ConfigurationProperties(prefix = "spring.easy.auto.school")
public class School implements ISchool {

    Klass class1;

    @Override
    public void ding(){

        System.out.println("Class1 have " + this.class1.getStudents().size());

    }
    
}
