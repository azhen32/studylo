package com.azhen.service.impl;

import com.azhen.domain.Authorities;
import com.azhen.domain.Roles;
import com.azhen.domain.RolesAuthorities;
import com.azhen.domain.RolesExample;
import com.azhen.dto.EUDataGridResult;
import com.azhen.dto.Result;
import com.azhen.mapper.AuthoritiesMapper;
import com.azhen.mapper.RolesAuthoritiesMapper;
import com.azhen.mapper.RolesMapper;
import com.azhen.mapper.UsersRolesMapper;
import com.azhen.service.RoleService;
import com.azhen.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by azhen on 17-2-4.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private AuthoritiesMapper authoritiesMapper;
    @Autowired
    private RolesAuthoritiesMapper rolesAuthoritiesMapper;
    @Autowired
    UsersRolesMapper usersRolesMapper;


    @Override
    public EUDataGridResult getRoleList(Integer page, Integer rows) {
        RolesExample example = new RolesExample();
        PageHelper.startPage(page,rows);
        List<Roles> list = rolesMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);

        PageInfo<Roles> pageInfo = new PageInfo<Roles>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Roles save(String ids, String name) {
        //新建角色
        Roles role = new Roles();
        role.setName(name);
        role.setState("1");
        rolesMapper.insert(role);

        //构造角色的权限ID
        List<String> idList = StringUtil.toList(ids);
        Set<Long> set = new HashSet<>();
        Authorities authorities = null;
        Long aId = 0L;
        for(int i = 0,size = idList.size(); i < size; i ++) {
            aId = Long.valueOf(idList.get(i));
            if(!set.isEmpty() && !set.contains(aId)) {
                authorities = authoritiesMapper.selectByPrimaryKey(aId);
                set.add(authorities.getId());
                set.add(authorities.getParentId());
            }
        }

        //建立角色和权限的关联
        for(Long id: set) {
            RolesAuthorities rs = new RolesAuthorities();
            rs.setRoleId(role.getId());
            rs.setAuthorityId(id.intValue());
            rolesAuthoritiesMapper.insert(rs);
        }

        return role;
    }
}
