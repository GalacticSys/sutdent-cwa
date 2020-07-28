package com.hjt.pojo;

import java.util.List;

public class GuanliYuanActive {
    private GuanLiYuan guanLiYuan;
    private List<Permission> permissionLsit;
    private List<Role> roleList;

    public GuanliYuanActive(GuanLiYuan guanLiYuan, List<Permission> permissionLsit, List<Role> roleList) {
        this.guanLiYuan = guanLiYuan;
        this.permissionLsit = permissionLsit;
        this.roleList = roleList;
    }
    public GuanliYuanActive(){

    }

    public GuanLiYuan getGuanLiYuan() {
        return guanLiYuan;
    }

    public void setGuanLiYuan(GuanLiYuan guanLiYuan) {
        this.guanLiYuan = guanLiYuan;
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
        return "GuanliYuanActive{" +
                "guanLiYuan=" + guanLiYuan +
                ", permissionLsit=" + permissionLsit +
                ", roleList=" + roleList +
                '}';
    }
}
