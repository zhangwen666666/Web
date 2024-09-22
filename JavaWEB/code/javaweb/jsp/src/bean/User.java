package bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID= 197418027987453L;
    private String username;
    private String password;
    private int age;
    private boolean sex;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && sex == user.sex && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, age, sex);
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

    /*public String getAge() {
        return "age";
    }*/

    public int isAge() {
        return age+10;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSex() {
        return sex;
    }
    public boolean isSex() {
        return !sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public User(String username, String password, int age, boolean sex) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }
}
