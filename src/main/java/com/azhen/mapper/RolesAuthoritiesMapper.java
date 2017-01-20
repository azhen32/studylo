package com.azhen.mapper;

import com.azhen.domain.RolesAuthorities;
import com.azhen.domain.RolesAuthoritiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesAuthoritiesMapper {
    int countByExample(RolesAuthoritiesExample example);

    int deleteByExample(RolesAuthoritiesExample example);

    int insert(RolesAuthorities record);

    int insertSelective(RolesAuthorities record);

    List<RolesAuthorities> selectByExample(RolesAuthoritiesExample example);

    int updateByExampleSelective(@Param("record") RolesAuthorities record, @Param("example") RolesAuthoritiesExample example);

    int updateByExample(@Param("record") RolesAuthorities record, @Param("example") RolesAuthoritiesExample example);
}