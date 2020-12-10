package com.isaac.easy.mysqldbsample;

import com.isaac.easy.mysqldbsample.config.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ImportResource({"classpath:spring-dubbo.xml"})
@MapperScan(basePackages = "com.isaac.easy.mysqldbsample.dao")
@Import({DynamicDataSourceConfig.class})
public class MysqlDbSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlDbSampleApplication.class, args);
	}

}
