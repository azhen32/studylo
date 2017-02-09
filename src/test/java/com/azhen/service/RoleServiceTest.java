package com.azhen.service;

import com.azhen.domain.Authorities;
import com.azhen.domain.Roles;
import com.azhen.domain.RolesAuthorities;
import com.azhen.mapper.AuthoritiesMapper;
import com.azhen.mapper.RolesAuthoritiesMapper;
import com.azhen.mapper.RolesMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})
@Transactional
public class RoleServiceTest {
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private AuthoritiesMapper authoritiesMapper;
    @Autowired
    private RolesAuthoritiesMapper rolesAuthoritiesMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleAuthorityService roleAuthorityService;
    @Test
    public void save() throws Exception {
        //测试数据准备
        Authorities a1 = new Authorities();
        a1.setId(100001L);
        a1.setStatus((byte)0x01);
        a1.setDisplayName("测试权限1");
        authoritiesMapper.insert(a1);
        Authorities a2 = new Authorities();
        a2.setId(100002L);
        a2.setStatus((byte)0x01);
        a2.setDisplayName("测试权限2");
        authoritiesMapper.insert(a2);

        //执行测试方法
        String ids = "100001,100002";
        String name = "测试角色1";
        Roles role = roleService.save(ids,name);

        //数据验证
        List<RolesAuthorities> arList = roleAuthorityService.getByRoleId(role.getId().longValue());
        assertEquals(arList,2);
    }

}