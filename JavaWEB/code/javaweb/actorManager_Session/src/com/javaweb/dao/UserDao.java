package com.javaweb.dao;

import com.javaweb.bean.User;

import java.util.List;

public class UserDao extends BaseDao {
    public boolean isExist(User user) {
        String sql = "select username,password from t_user where username=? and password=?";
        List<User> users = executeQuery(User.class, sql, user.getUsername(), user.getPassword());
        return !users.isEmpty();
    }
}
