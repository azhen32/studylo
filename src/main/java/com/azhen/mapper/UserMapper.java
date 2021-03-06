package com.azhen.mapper;

import com.azhen.domain.User;
import com.azhen.domain.UserExample;
import java.util.List;
import java.util.Map;

import com.azhen.domain.UsersRoles;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    List<User> selectByExampleAll(UserExample example);

    User selectByPrimaryKey(Long id);

    int batchUpdate(@Param("record")User user,@Param("list")List<String> idList);
    int batchDelete(List<String> list);

    UsersRoles findUserRoleById(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


}