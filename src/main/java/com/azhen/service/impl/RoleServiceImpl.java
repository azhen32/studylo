package com.azhen.service.impl;

import com.azhen.mapper.RolesMapper;
import com.azhen.mapper.UsersRolesMapper;
import com.azhen.service.RoleService;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by azhen on 17-2-4.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    UsersRolesMapper usersRolesMapper;


}
