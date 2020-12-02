package com.isaac.easy.mysqldbsample.db.aspect;

import com.isaac.easy.mysqldbsample.db.DataSourceEnum;
import com.isaac.easy.mysqldbsample.db.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author think
 * @date 2020/12/1
 */
@Aspect
@Component
public class DataSourceAspect {
    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);


    @Pointcut("execution(* com.isaac.easy.mysqldbsample.mall..*.select*(..))")
    public void select() {
    }
    @Around("select()")
    public Object aroundSelect( ProceedingJoinPoint point) throws Throwable {
        logger.info("Hello this is slave!!!");
        DynamicDataSource.setDataSource(DataSourceEnum.Slave.getName());
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }
    @Pointcut("execution(* com.isaac.easy.mysqldbsample.mall..*.insert*(..))")
    public void insert() {
    }
    @Around("insert()")
    public Object aroundInsert( ProceedingJoinPoint point) throws Throwable {
        logger.info("Hello this is Master!!!");
        DynamicDataSource.setDataSource(DataSourceEnum.Master.getName());
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }
}
