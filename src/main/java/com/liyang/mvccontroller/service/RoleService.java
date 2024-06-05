package com.liyang.mvccontroller.service;

import com.liyang.mvccontroller.entity.Role;
import com.liyang.mvccontroller.entity.RoleParams;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleService {
    @Select("select * from roles where id = #{id}")
    Role getRole(@Param("id") long id);

    @Select("select * from roles limit #{roleParams.start}, #{roleParams.limit}")
    List<Role> findRoles(@Param("roleParams")RoleParams roleParams);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into roles (name, note) values (#{role.name}, #{role.note})")
    void insertRole(@Param("role") Role role);
}
