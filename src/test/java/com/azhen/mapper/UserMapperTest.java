package com.azhen.mapper;

import com.azhen.domain.Roles;
import com.azhen.domain.User;
import com.azhen.domain.UserExample;
import com.azhen.domain.UsersRoles;
import org.junit.Before;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserMapperTest  {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UsersRolesMapper usersRolesMapper;
    @Autowired
    private RolesMapper rolesMapper;
    private long userId;

    @Before
    public void before() {
      /*  User user = new User("azhen","1234");
        user.setId(Long.valueOf(1));
        user.setUpdateTime(new Date());
        userMapper.insert(user);
        userId = user.getId();

        Roles roles1 = new Roles();
        roles1.setId(1);
        roles1.setName("roles1");
        roles1.setState("1");
        Roles roles2 = new Roles();
        roles2.setId(2);
        roles2.setName("roles2");
        roles2.setState("1");
        int role1Id = rolesMapper.insert(roles1);
        int role2Id = rolesMapper.insert(roles2);

        UsersRoles usersRoles1 = new UsersRoles();
        UsersRoles usersRoles2 = new UsersRoles();
        usersRoles1.setUserId(userId);
        usersRoles1.setRoleId(role1Id);
        usersRoles2.setUserId(userId);
        usersRoles2.setRoleId(role2Id);
        usersRolesMapper.insert(usersRoles1);
        usersRolesMapper.insert(usersRoles2);*/
    }

    @Test
    @Transactional
    //@Rollback(false)    //此方法不会滚
    public void save() {
        User user = new User();
        user.setId(Long.valueOf(1));
        user.setEmail("296426127@qq.com");
        user.setCreateTime(new Date());
        user.setUpdateTime(user.getCreateTime());
        user.setNickname("azhen");
        userMapper.insert(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    @Transactional  //只设置@Transactional 已经可以让数据回滚
    public void selectByExampleAll() throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userId);
        List<User> userList = userMapper.selectByExampleAll(example);
        for(User user : userList) {
            assertThat(user.getUsersRoles()).isNotEmpty();
        }
    }
}
