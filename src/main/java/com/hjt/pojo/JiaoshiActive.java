package com.hjt.pojo;

import lombok.ToString;

import java.util.List;

@ToString
public class JiaoshiActive {
    private JiaoShi jiaoShi;
    private List<Permission> permissionLsit;
    private List<Role> roleList;

    public JiaoshiActive(JiaoShi jiaoShi, List<Permission> permissionLsit, List<Role> roleList) {
        this.jiaoShi = jiaoShi;
        this.permissionLsit = permissionLsit;
        this.roleList = roleList;
    }

    public JiaoshiActive() {
    }

    public JiaoShi getJiaoShi() {
        return jiaoShi;
    }

    public void setJiaoShi(JiaoShi jiaoShi) {
        this.jiaoShi = jiaoShi;
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
}
