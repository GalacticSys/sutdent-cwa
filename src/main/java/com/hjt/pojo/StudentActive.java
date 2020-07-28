package com.hjt.pojo;

import java.util.List;

public class StudentActive {
    private Student student;
    private List<Permission> permissionLsit;
    private List<Role> roleList;

    public StudentActive(Student student, List<Permission> permissionLsit, List<Role> roleList) {
        this.student = student;
        this.permissionLsit = permissionLsit;
        this.roleList = roleList;
    }

    public StudentActive() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
        return "StudentActive{" +
                "student=" + student +
                ", permissionLsit=" + permissionLsit +
                ", roleList=" + roleList +
                '}';
    }
}
