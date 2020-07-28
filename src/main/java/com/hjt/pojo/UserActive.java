package com.hjt.pojo;

import java.util.List;

public class UserActive {
    private Object object;
    private List<Permission> permissionLsit;
    private List<Role> roleList;

    public UserActive(Object object, List<Permission> permissionLsit, List<Role> roleList) {
        this.object = object;
        this.permissionLsit = permissionLsit;
        this.roleList = roleList;
    }
    public UserActive(){

    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<Permission> getPermissionLsit() {
        return permissionLsit;
    }

    public void setPermissionLsit(List<Permission> permissionLsit) {
        this.permissionLsit = permissionLsit;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserActive{" +
                "object=" + object +
                ", permissionLsit=" + permissionLsit +
                ", roleList=" + roleList +
                '}';
    }
}
