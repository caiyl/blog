package com.cai.blog.entity;

import java.io.Serializable;

/**
 * Created by caiyl on 2018/2/8.
 */
public class Role implements Serializable{
    private String id;
    private String roleCode;
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
