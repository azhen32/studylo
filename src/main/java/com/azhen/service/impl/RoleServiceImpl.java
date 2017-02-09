package com.azhen.service.impl;

import com.azhen.domain.Roles;
import com.azhen.domain.RolesExample;
import com.azhen.dto.EUDataGridResult;
import com.azhen.mapper.RolesMapper;
import com.azhen.mapper.UsersRolesMapper;
import com.azhen.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by azhen on 17-2-4.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RolesMapper rolesMapper;
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
}
