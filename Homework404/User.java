package Homework404;

import java.awt.*;
import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -3848884680768026789L;
    private String userName;//用户名
    private String password;//密码

    public User() {
    }

    public User(String userName, String password) {
        setUserName(userName);
        setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
