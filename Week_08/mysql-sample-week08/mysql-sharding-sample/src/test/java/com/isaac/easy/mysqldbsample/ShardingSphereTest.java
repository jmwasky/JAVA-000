package com.isaac.easy.mysqldbsample;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author think
 * @date 2020/12/2
 */
public class ShardingSphereTest {
    @Test
    public void shardingTest () throws IOException, SQLException {
        // 获取数据源
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-sharding.yaml"));
        Connection connection = dataSource.getConnection();
        System.out.println("------" + connection.getClass());

        System.out.println("------" + dataSource.getClass());


        connection.close();

    }
    private static File getFile( final String configFile) {
        return new File(ShardingSphereTest.class.getResource(configFile).getFile());
    }

    @Test
    public void createTableTest () throws IOException, SQLException {
        // 获取数据源
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-sharding.yaml"));

        String createSql = "CREATE TABLE `t_order` (\n" +
                "  `id` bigint(11) NOT NULL COMMENT '主键ID',\n" +
                "  `account_id` bigint(11) NOT NULL COMMENT '用户ID',\n" +
                "  `product_id` bigint(11) NOT NULL COMMENT '产品ID',\n" +
                "  `consume_count` int(10) NOT NULL COMMENT '消费数目',\n" +
                "  `total_amount` bigint(11) NOT NULL COMMENT '消费总额',\n" +
                "  `delivery_id` bigint(11) NOT NULL COMMENT '配送信息ID',\n" +
                "  `status` int(5) NOT NULL COMMENT '订单支付状态：1已支付，2未支付',\n" +
                "  `create_time` bigint(11) NOT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';\n";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(createSql);

        preparedStatement.execute();
        connection.close();
    }
    @Test
    public void dropTableTest () throws IOException, SQLException {
        // 获取数据源
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-sharding.yaml"));

        String createSql = "drop TABLE `t_order`;";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(createSql);

        preparedStatement.execute();
        connection.close();
    }
    @Test
    public void truncateTableTest () throws IOException, SQLException {
        // 获取数据源
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-sharding.yaml"));

        String createSql = "truncate TABLE `t_order`;";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(createSql);

        preparedStatement.execute();
        //connection.close();
    }
    @Test
    public void insertValueTest() throws IOException, SQLException {
        // 获取数据源
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-sharding.yaml"));

        Connection connection = dataSource.getConnection();

        String sql = "insert into t_order(`account_id`, `product_id`, `consume_count`, `total_amount`, `delivery_id`, `status`, `create_time`) " +
                " values(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            preparedStatement.setLong(1, i);
            preparedStatement.setLong(2, 1);
            preparedStatement.setLong(3, random.nextInt(10));
            preparedStatement.setLong(4, random.nextInt(100));
            preparedStatement.setLong(5, 1);
            preparedStatement.setLong(6, 1);
            preparedStatement.setLong(7, System.currentTimeMillis());
            preparedStatement.execute();
        }
        connection.close();
    }
    @Test
    public void updateValueTest() throws IOException, SQLException {
        // 获取数据源
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-sharding.yaml"));

        Connection connection = dataSource.getConnection();

        String sql = "select id from t_order limit 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long selectId = 0L;
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while(rs.next()) {
                selectId = rs.getLong(1);
            }
        }
        String updateById = "update t_order set account_id = 10000 where id = ?";
        preparedStatement = connection.prepareStatement(updateById);
        preparedStatement.setLong(1, selectId);
        preparedStatement.executeUpdate();

        String selectById = "select `id`,`account_id`, `product_id`, `consume_count`, `total_amount`, " +
                "`delivery_id`, `status`, `create_time` from t_order where id = ?";
        preparedStatement = connection.prepareStatement(selectById);
        preparedStatement.setLong(1, selectId);
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while(rs.next()) {
                System.out.println("id:" + rs.getLong(1));
                System.out.println("account:" + rs.getLong(2));
                System.out.println("product_id:" + rs.getLong(3));
                System.out.println("consume_count:" + rs.getLong(4));
                System.out.println("total_amount:" + rs.getLong(5));
                System.out.println("delivery_id:" + rs.getLong(6));
                System.out.println("status:" + rs.getLong(7));
                System.out.println("create_time:" + rs.getLong(8));
            }
        }

        connection.close();
    }

}
