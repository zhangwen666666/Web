package com.javaweb.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User2 implements Serializable {
    @Serial
    private static final long serialVersionUID=46467211294120L;

    private String usercode;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User2{" +
                "usercode='" + usercode + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User2 user2 = (User2) o;
        return Objects.equals(usercode, user2.usercode) && Objects.equals(username, user2.username) && Objects.equals(password, user2.password);
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

    public User2(String usercode, String username, String password) {
        this.usercode = usercode;
        this.username = username;
        this.password = password;
    }

    public User2() {
    }
}
