package com.azhen.mapper;

import com.azhen.domain.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//如果要回滚的话，需要注入事务管理器
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-trans.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserMapperTest  {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UsersRolesMapper usersRolesMapper;
    @Autowired
    private RolesMapper rolesMapper;


    //@Before
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
        UsersRoles usersRoles2 = new UsersRoles();
        usersRoles1.setUserId(1L);
        usersRoles1.setRoleId(1);
        usersRoles2.setUserId(1L);
        usersRoles2.setRoleId(2);
        usersRolesMapper.insert(usersRoles1);
        usersRolesMapper.insert(usersRoles2);


    }

    @Test
    //@Rollback(false)    //此方法不会滚
    public void save() {
        User user = new User();
        user.setId(Long.valueOf(2));
        user.setEmail("296426127@qq.com");
        user.setCreateTime(new Date());
        user.setUpdateTime(user.getCreateTime());
        user.setNickname("azhen");
        userMapper.insert(user);
        assertThat(user.getId()).isNotNull();
    }

    @Ignore
    @Test
    public void findUserRoleById() throws Exception {
        UsersRoles usersRoles1 = new UsersRoles();
        usersRoles1.setUserId(1L);
        usersRoles1.setRoleId(1);
        usersRolesMapper.insert(usersRoles1);
        UsersRoles usersRoles = usersRolesMapper.findByUserId(1L);
        assertNotNull(usersRoles);
    }

    @Test
    public void selectByExampleAll() throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(1L);
        List<User> userList = userMapper.selectByExampleAll(example);
        for(User user : userList) {
            assertThat(user.getUserRoles()).isNotEmpty();
        }
    }


    @Test
    public void updateBatch() throws Exception {

    }
}
