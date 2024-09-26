package com.javaweb.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            // System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, null, null);
        }
    }
}
