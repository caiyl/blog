package com.cai.blog.entity;


import java.io.Serializable;

/**
 * Created by caiyl on 2017/10/2.
 */
public class User implements Serializable {

    private String id;
    private String userName;
    private String userNameCN;
    private String password;
    private String userSex;

    public User(){}

    public User(String id, String userName, String userNameCN, String password, String userSex) {
        this.id = id;
        this.userName = userName;
        this.userNameCN = userNameCN;
        this.password = password;
        this.userSex = userSex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameCN() {
        return userNameCN;
    }

    public void setUserNameCN(String userNameCN) {
        this.userNameCN = userNameCN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
