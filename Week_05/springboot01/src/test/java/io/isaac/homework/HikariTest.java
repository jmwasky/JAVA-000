package io.isaac.homework;

import com.zaxxer.hikari.HikariDataSource;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author isaac
 * @date 2020/11/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HikariTest.class)
@ComponentScan("io.isaac.springboot01.hikari")
@SpringBootApplication
public class HikariTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        Connection data = dataSource.getConnection();

        System.out.println("------" + data.getClass());

        System.out.println("------" + dataSource.getClass());

        data.close();
    }
    /**
     * 预编译查询
     * @throws SQLException
     */
    @Test
    public void selectTest() throws SQLException {
        String sql = "select id,user_name, user_password, user_age from `user` where id = ?";

        Connection connection = dataSource.getConnection();
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

    }
}
