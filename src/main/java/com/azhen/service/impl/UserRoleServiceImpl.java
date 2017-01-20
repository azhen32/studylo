package com.azhen.service.impl;

import com.azhen.domain.UsersRoles;
import com.azhen.domain.UsersRolesExample;
import com.azhen.mapper.UsersRolesMapper;
import com.azhen.service.UserRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by azhen on 17-1-20.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UsersRolesMapper usersRolesMapper;
    public List<UsersRoles> find(Long userId) {
        UsersRolesExample example = new UsersRolesExample();
        UsersRolesExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UsersRoles> list = usersRolesMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(list)) {
            return list;
        }
        return null;
    }
}
