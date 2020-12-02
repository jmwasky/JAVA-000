package com.isaac.easy.mysqldbsample.config;

import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.google.common.collect.Maps;
import com.isaac.easy.mysqldbsample.db.DataSourceEnum;
import com.isaac.easy.mysqldbsample.db.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author think
 * @date 2020/12/1
 */
@Configuration
@Component
@MapperScan(basePackages="com.isaac.easy.mysqldbsample.mall.dao.dynamic")
public class DynamicDataSourceConfig {
    @Autowired
    private Environment env;

    @Bean(name = "masterDataSource")
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource( DataSource masterDataSource, DataSource secondaryDataSource) {
        Map<Object, Object> targetDataSources = Maps.newConcurrentMap();
        targetDataSources.put(DataSourceEnum.Master.getName(), masterDataSource);
        targetDataSources.put(DataSourceEnum.Slave.getName(), secondaryDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }
    @Primary
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory( DataSource masterDataSource, DataSource secondaryDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(this.dataSource(masterDataSource, secondaryDataSource));
        sessionFactory.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(env.getProperty("mybatis.mapper-locations")));

        return sessionFactory.getObject();
    }
    @Primary
    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager( @Qualifier("dataSource") DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}
