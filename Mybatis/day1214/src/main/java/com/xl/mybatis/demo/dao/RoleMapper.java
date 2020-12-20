package com.xl.mybatis.demo.dao;

import com.xl.mybatis.demo.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("SELECT * FROM  `role` r , `user_role` ur WHERE r.id = ur.role_id AND ur.user_id =#{uid}")
    List<Role> findByUid(Integer uid);
}
