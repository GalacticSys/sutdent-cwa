package com.hjt.dao;

import com.hjt.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    public List<Role> findRoleByUserId(@Param("stuId")String stuId, @Param("type")String type);
}
