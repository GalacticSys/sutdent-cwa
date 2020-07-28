package com.hjt.dao;

import com.hjt.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    public List<Permission> findPermissionByRoleId(@Param("roleId") Integer roleId);
}
