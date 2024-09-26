package com.javaweb.dao;

import com.javaweb.utils.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 最基础的DAO，所有的DAO都应该继承这个DAO类
 */
public class BaseDao {
    /**
     * 负责执行 insert update delete 语句的方法
     *
     * @param sql    要执行的sql语句
     * @param params 给sql语句传递的参数
     * @return 影响的记录条数
     */
    public int executeUpdate(String sql, Object... params) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 1; i <= params.length; i++) {
                    ps.setObject(i, params[i - 1]);
                }
            }
            count = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }


    /**
     * 负责执行查询select语句的方法
     * @param c 要查询的数据对应的java类
     * @param sql 查询sql语句
     * @param params 给预编译的sql语句传递的采纳数
     * @return 存放查询结果集的List集合，未查询到时List集合的长度为0
     * @param <T> 泛型
     */
    public <T> List<T> executeQuery(Class<T> c,String sql, Object... params) {
        List<T> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 1; i <= params.length; i++) {
                    ps.setObject(i, params[i - 1]);
                }
            }
            rs = ps.executeQuery();
            // 获取结果集中列的数量
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            // 遍历结果集
            while (rs.next()){
                // 通过反射机制创建对象
                T obj = c.getDeclaredConstructor().newInstance();
                for(int i = 1; i<=columnCount; i++){
                    // 获取属性名
                    String fieldName = metaData.getColumnName(i);
                    Field field = c.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(obj, rs.getObject(i));
                }
                list.add(obj);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }
}
