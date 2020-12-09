package com.isaac.easy.mysqldbsample.hikari;

import cn.hutool.core.date.DateUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Calendar;
import java.util.Random;

/**
 * @author isaac
 * @date 2020/11/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HikariDBTest.class)
@ComponentScan("io.isaac.easy.mysqldbsample.config")
@SpringBootApplication
@Ignore
public class HikariDBTest {

    @Autowired
    private DataSource dataSource;

    private Long RECORDS_COUNT = 1000*10000L;

    @Test
    public void test() throws SQLException {
        Connection data = dataSource.getConnection();

        System.out.println("------" + data.getClass());

        System.out.println("------" + dataSource.getClass());

        data.close();
    }
    /**
     * 插入用户
     * @throws SQLException
     */
    @Test
    public void insertAccountTest() throws SQLException {
        String sql = "insert into t_account(`account_name`,`password`, `create_time`) " +
                " values(?, ?, ?)";

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 20; i++) {
            preparedStatement.setString(1, "account_test"+i);
            preparedStatement.setString(2, "xxxxxpassword"+i);
            preparedStatement.setString(3, System.currentTimeMillis()+"");
            preparedStatement.execute();
        }
    }
    /**
     * 一个线程
     * @throws SQLException
     */
    @Test
    public void insertOrderTest1() throws SQLException {
        String sql = "insert into t_order(`account_id`, `product_id`, `consume_count`, `total_amount`, `delivery_id`, `status`, `create_time`) " +
                     " values(?, ?, ?, ?, ?, ?, ?)";
        Long startTime = System.currentTimeMillis();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Random random = new Random();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            preparedStatement.setLong(1, i);
            preparedStatement.setLong(2, 1);
            preparedStatement.setLong(3, random.nextInt(10));
            preparedStatement.setLong(4, random.nextInt(100));
            preparedStatement.setLong(5, 1);
            preparedStatement.setLong(6, 1);
            preparedStatement.setLong(7, System.currentTimeMillis());
            preparedStatement.execute();
        }
        Long endTime = System.currentTimeMillis();
        /**
         * 线程池配置1个，插入花费时间：15分钟插入25w行  100w大概60分钟
         * 线程池配置10个，插入花费时间： 100w 大约 52分钟
         */
        System.out.println("插入"+RECORDS_COUNT+"条记录花费：" + (endTime - startTime) + "毫秒。");
    }
    /**
     * 线程池配置10个线程 批量处理 100w大约33分钟 性能提升一倍
     * @throws SQLException
     */
    @Test
    public void insertOrderTest2() throws SQLException {
        String sql = "insert into t_order(`account_id`, `product_id`, `consume_count`, `total_amount`, `delivery_id`, `status`, `create_time`) " +
                " values(?, ?, ?, ?, ?, ?, ?)";
        Long startTime = System.currentTimeMillis();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Random random = new Random();
        for (int i = 0; i < RECORDS_COUNT; i++) {
            preparedStatement.setLong(1, i);
            preparedStatement.setLong(2, 1);
            preparedStatement.setLong(3, random.nextInt(10));
            preparedStatement.setLong(4, random.nextInt(100));
            preparedStatement.setLong(5, 1);
            preparedStatement.setLong(6, 1);
            preparedStatement.setLong(7, System.currentTimeMillis());
            preparedStatement.addBatch();
            if (i % 10000 == 0) {
                System.out.println( "i:"  + i);
                preparedStatement.executeBatch();
            }
        }
        preparedStatement.executeBatch();
        Long endTime = System.currentTimeMillis();
        System.out.println("插入"+RECORDS_COUNT+"条记录花费：" + (endTime - startTime) + "毫秒。");
    }

    /**
     * 16-18秒
     * insert values (),(),()
     * @throws SQLException
     */
    @Test
    public void writSqlTest() throws SQLException {

        String sql = "insert into t_order(`account_id`, `product_id`, `consume_count`, `total_amount`, `delivery_id`, `status`, `create_time`) values";
        Random random = new Random();
        String comma = ",";
        Long startTime = System.currentTimeMillis();
        Connection connection = dataSource.getConnection();
        for (int i = 0; i < 100; i++) {
            System.out.println("start at： " + i);
            StringBuilder valueSql = new StringBuilder();
            for (int j = 0; j < 10000; j++) {
                valueSql.append("(" + (i+j)).append(comma)
                        .append(1).append(comma)
                        .append(random.nextInt(10)).append(comma)
                        .append(random.nextInt(100)).append(comma)
                        .append(1).append(comma)
                        .append(1).append(comma)
                        .append(System.currentTimeMillis()).append(")").append(comma);
            }
            String value = valueSql.toString();
            String valueResult = sql + value.substring(0, value.length()-1);
            PreparedStatement preparedStatement = connection.prepareStatement(valueResult);
            preparedStatement.execute();
        }
        Long endTime = System.currentTimeMillis();
        // 插入10000000条记录花费：18710毫秒。
        System.out.println("插入"+RECORDS_COUNT+"条记录花费：" + (endTime - startTime) + "毫秒。");
    }

}
