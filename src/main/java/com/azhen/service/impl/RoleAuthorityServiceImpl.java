package com.azhen.service.impl;

import com.azhen.domain.RolesAuthorities;
import com.azhen.domain.RolesAuthoritiesExample;
import com.azhen.mapper.RolesAuthoritiesMapper;
import com.azhen.service.RoleAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {
    @Autowired
    private RolesAuthoritiesMapper rolesAuthoritiesMapper;
    @Override
    public List<RolesAuthorities> getByRoleId(Long roleId) {
        RolesAuthoritiesExample example = new RolesAuthoritiesExample();
        RolesAuthoritiesExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId.intValue());
        return rolesAuthoritiesMapper.selectByExample(example);
    }
}
