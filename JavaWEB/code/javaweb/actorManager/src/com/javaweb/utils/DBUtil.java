package com.javaweb.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class DBUtil {
    private static DataSource dataSource = null;

    static {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/dbutil.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从连接池中获取连接
     *
     * @return 连接对象
     * @throws SQLException SQL异常
     */
    public static Connection getConnection() throws SQLException {
        if (dataSource == null)
            throw new SQLException("获取连接失败");
        return dataSource.getConnection();
    }


    /**
     * 关闭资源
     *
     * @param conn      连接对象
     * @param statement 数据库操作对象
     * @param ret       结果集对象
     */
    public static void close(Connection conn, Statement statement, ResultSet ret) {
        if (ret != null) {
            try {
                ret.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
