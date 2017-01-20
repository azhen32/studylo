package com.azhen.mapper;

import com.azhen.domain.User;
import com.azhen.domain.UsersRoles;
import com.azhen.domain.UsersRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersRolesMapper {
    int countByExample(UsersRolesExample example);

    int deleteByExample(UsersRolesExample example);

    int insert(UsersRoles record);

    UsersRoles findByUserId(Long userId);

    int insertSelective(UsersRoles record);

    List<UsersRoles> selectByExample(UsersRolesExample example);

    int updateByExampleSelective(@Param("record") UsersRoles record, @Param("example") UsersRolesExample example);

    int updateByExample(@Param("record") UsersRoles record, @Param("example") UsersRolesExample example);
}