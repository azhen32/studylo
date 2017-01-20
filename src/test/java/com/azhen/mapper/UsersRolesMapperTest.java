package com.azhen.mapper;

import com.azhen.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by azhen on 17-1-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//如果要回滚的话，需要注入事务管理器
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-trans.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UsersRolesMapperTest {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UsersRolesMapper usersRolesMapper;
    @Autowired
    private RolesMapper rolesMapper;

    @Before
    public void before() {
        User user = new User("azhen","1234");
        user.setId(1L);
        user.setUpdateTime(new Date());
        userMapper.insert(user);

        Roles roles1 = new Roles();
        roles1.setId(1);
        roles1.setName("roles1");
        roles1.setState("1");
        Roles roles2 = new Roles();
        roles2.setId(2);
        roles2.setName("roles2");
        roles2.setState("1");
        rolesMapper.insert(roles1);
        rolesMapper.insert(roles2);

        UsersRoles usersRoles1 = new UsersRoles();
        usersRoles1.setUserId(1L);
        usersRoles1.setRoleId(1);
        usersRolesMapper.insert(usersRoles1);

        UsersRoles usersRoles2 = new UsersRoles();
        usersRoles2.setUserId(1L);
        usersRoles2.setRoleId(2);
        usersRolesMapper.insert(usersRoles2);
    }
    @Test
    public void selectByExample() throws Exception {
        UsersRolesExample example = new UsersRolesExample();
        UsersRolesExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(1L);
        List<UsersRoles> usersRolesList = usersRolesMapper.selectByExample(example);
        assertThat(usersRolesList).hasSize(2);
        for(UsersRoles ur : usersRolesList) {
            ur.getUser();
        }
    }
}