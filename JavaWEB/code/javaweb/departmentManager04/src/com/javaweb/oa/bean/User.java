package com.javaweb.oa.bean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User implements HttpSessionBindingListener, Serializable {
    private String username;
    private String password;

    @Serial
    private static final long serialVersionUID = -7329187319L;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        ServletContext application = event.getSession().getServletContext();
        Object count = application.getAttribute("count");
        if (count == null) {
            application.setAttribute("count", 1);
        } else {
            int temp = (Integer) count;
            temp++;
            application.setAttribute("count", temp);
        }
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        ServletContext application = event.getSession().getServletContext();
        Object count = application.getAttribute("count");
        if (count == null) {
            throw new RuntimeException();
        } else {
            int temp = (Integer) count;
            temp--;
            application.setAttribute("count", temp);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
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

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
