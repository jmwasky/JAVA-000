package com.isaac.easy.mysqldbsample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.isaac.easy.mysqldbsample.dao")
public class MysqlDbSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlDbSampleApplication.class, args);
	}

}
