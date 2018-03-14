package com.cai.blog.entity;

import java.io.Serializable;

/**
 * Created by caiyl on 2018/2/9.
 */
public class UserRole implements Serializable {
    private String userName;
    private String roleCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
