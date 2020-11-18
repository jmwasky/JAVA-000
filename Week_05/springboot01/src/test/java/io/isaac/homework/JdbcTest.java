package io.isaac.homework;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author think
 * @date 2020/11/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JdbcTest.class)
@ComponentScan("io.isaac.springboot01.jdbc")
@SpringBootApplication
public class JdbcTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private Connection connection;

    @Test
    public void test() throws SQLException {
        Connection data = dataSource.getConnection();

        System.out.println("------" + data.getClass());

        System.out.println("------" + dataSource.getClass());

        data.close();
    }
    @Test
    public void createTableTest() throws SQLException {
        String createSql = "CREATE TABLE IF NOT EXISTS `user`("
                + "`id` INT UNSIGNED AUTO_INCREMENT,"
                + " `user_name` VARCHAR(100),"
                + " `user_password` VARCHAR(100),"
                + " `user_age` INT(11),"
                + "PRIMARY KEY ( `id` )"
                + ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        //开启事务
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(createSql);
        preparedStatement.executeUpdate();

        /*String drop = "drop TABLE `user`;";
        preparedStatement.execute(drop);*/

        //提交事务
        connection.commit();
        connection.close();
    }
    @Test
    public void insertTest() throws SQLException {
        String sql = "insert into `user`(user_name, user_password, user_age) " +
                "values('liangchao', 'password', 18)," +
                "('liangchao2', 'password2', 19)";
        //开启事务
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        //提交事务
        connection.commit();
        connection.close();
    }

    /**
     * 预编译查询
     * @throws SQLException
     */
    @Test
    public void selectTest() throws SQLException {
        String sql = "select id,user_name, user_password, user_age from `user` where id = ?";
        //开启事务
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "1");
        ResultSet resultSet = preparedStatement.executeQuery();

        ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i+1);
                String columnValue = resultSet.getString(columnName);
                System.out.println("columnName:" + columnName + ", columnValue：" + columnValue);
            }
        }
        //提交事务
        connection.commit();
        connection.close();
    }
    @Test
    public void udpateTest() throws SQLException {
        String sql = "update `user` set user_name=? where user_name = ?";
        //开启事务
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "updateName");
        preparedStatement.setString(2, "liangchao");
        int result = preparedStatement.executeUpdate();
        Assert.assertEquals(1, result);
        //提交事务
        connection.commit();
        connection.close();
    }
    @Test
    public void deleteTest() throws SQLException {
        String sql = "delete from `user` where user_name = ?";
        //开启事务
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "updateName");
        int result = preparedStatement.executeUpdate();
        Assert.assertEquals(1, result);
        //提交事务
        connection.commit();
        connection.close();
    }
}
