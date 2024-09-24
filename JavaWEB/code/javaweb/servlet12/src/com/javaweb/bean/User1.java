package com.javaweb.bean;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User1 implements HttpSessionBindingListener, Serializable {
    @Serial
    private static final long serialVersionUID=7865419564127L;

    private String usercode;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User1 user = (User1) o;
        return Objects.equals(usercode, user.usercode) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usercode, username, password);
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User1(String usercode, String username, String password) {
        this.usercode = usercode;
        this.username = username;
        this.password = password;
    }

    public User1() {
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("向session域中绑定数据");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("向session域中解绑数据");
    }
}
