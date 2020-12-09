package com.isaac.easy.mysqldbsample.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author isaac
 * @date 2020/7/13
 */
@Configuration
//@MapperScan(basePackages="com.isaac.easy.mysqldbsample.mall.dao.secondary",sqlSessionTemplateRef="secondarySqlSessionTemplate")
//@MapperScan(basePackages="com.isaac.easy.mysqldbsample.mall.dao.secondary")
public class SecondaryServerDatabaseConfig {
    
   /* @Bean(name = "secondaryDataSource")
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Primary
    @Bean("secondarySqlSessionFactory")
    public SqlSessionFactory secondarySqlSessionFactory ( @Qualifier("secondaryDataSource") DataSource dataSource ) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapping/secondary/*.xml"));
        return sessionFactoryBean.getObject();
    }
    @Bean(name = "secondarySqlSessionTemplate")
    public SqlSessionTemplate secondarySqlSessionTemplate( @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    *//**
     * 配置事务管理
     * @param dataSource dataSource
     * @return DataSourceTransactionManager
     *//*
    @Primary
    @Bean(name = "secondaryTransactionManager")
    public DataSourceTransactionManager secondaryTransactionManager( @Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/
}
