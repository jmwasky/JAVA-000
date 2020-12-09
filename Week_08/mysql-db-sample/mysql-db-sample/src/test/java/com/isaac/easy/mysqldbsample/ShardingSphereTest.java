package com.isaac.easy.mysqldbsample;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.map.MapUtil;
import cn.hutool.db.Db;
import com.google.common.collect.Maps;
import com.isaac.easy.mysqldbsample.hikari.User;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactoryUtils;

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
@Ignore
public class ShardingSphereTest {
    @Test
    public void beanUtilMapToBean () throws IOException, SQLException {
        Map<String, Object> map = MapUtil.builder("user_password", (Object)"test")
                .put("NAME", "name")
                .put("user_name", "userj_name")
                .put("ab", "userj_name")
                .build();
        User user = BeanUtil.mapToBean(map, User.class, CopyOptions.create());
        System.out.println(user.toString());
    }


    @Test
    public void shardingTest () throws IOException, SQLException {
        // 获取数据源
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-tables.yaml"));
        Connection connection = dataSource.getConnection();
        System.out.println("------" + connection.getClass());

        System.out.println("------" + dataSource.getClass());

        selectValue(dataSource);

        insertValue(dataSource);
        connection.close();

    }
    private static File getFile( final String configFile) {
        return new File(ShardingSphereTest.class.getResource(configFile).getFile());
    }

    /**
     * 后台日志显示使用ds_1
     * @param dataSource
     * @throws SQLException
     */
    private static void selectValue(final DataSource dataSource) throws SQLException {
        String sql = "SELECT * FROM t_order limit 10";
        try (
             Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()) {
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getInt(2));
                    System.out.println(rs.getInt(3));
                    System.out.println(rs.getInt(4));
                    System.out.println(rs.getInt(5));
                    System.out.println(rs.getInt(6));
                    System.out.println(rs.getInt(7));
                    System.out.println(rs.getLong(8));
                }
            }
        }
    }

    /**
     * insert 自动使用ds_0
     * @param dataSource
     * @throws SQLException
     */
    private static void insertValue(final DataSource dataSource) throws SQLException {
        String sql = "insert into t_order(`account_id`, `product_id`, `consume_count`, `total_amount`, `delivery_id`, `status`, `create_time`) " +
                " values(?, ?, ?, ?, ?, ?, ?)";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            preparedStatement.setLong(1, i);
            preparedStatement.setLong(2, 1);
            preparedStatement.setLong(3, random.nextInt(10));
            preparedStatement.setLong(4, random.nextInt(100));
            preparedStatement.setLong(5, 1);
            preparedStatement.setLong(6, 1);
            preparedStatement.setLong(7, System.currentTimeMillis());
            preparedStatement.execute();
        }
    }
}
