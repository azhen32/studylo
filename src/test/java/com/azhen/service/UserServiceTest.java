package com.azhen.service;

import com.azhen.domain.Roles;
import com.azhen.domain.User;
import com.azhen.domain.UsersRoles;
import com.azhen.domain.Videos;
import com.azhen.mapper.RolesMapper;
import com.azhen.mapper.UserMapper;
import com.azhen.mapper.UsersRolesMapper;
import com.azhen.mapper.VideosMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by azhen on 17-1-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//如果要回滚的话，需要注入事务管理器
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml","classpath:spring/applicationContext-trans.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserServiceTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UsersRolesMapper usersRolesMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private VideosMapper videosMapper;

    @Before
    public void before() {
        User user = new User("azhen","1234");
        user.setId(1L);
        user.setUpdateTime(new Date());
        user.setEmail("111@qq.com");
        userMapper.insert(user);

        Roles roles1 = new Roles();
        roles1.setId(1);
        roles1.setName("roles1");
        roles1.setState("1");
        rolesMapper.insert(roles1);

        Roles roles2 = new Roles();
        roles2.setId(2);
        roles2.setName("roles2");
        roles2.setState("1");
        rolesMapper.insert(roles2);

        UsersRoles usersRoles1 = new UsersRoles();
        usersRoles1.setUserId(1L);
        usersRoles1.setRoleId(1);
        usersRolesMapper.insert(usersRoles1);

        UsersRoles usersRoles2 = new UsersRoles();
        usersRoles2.setUserId(1L);
        usersRoles2.setRoleId(2);
        usersRolesMapper.insert(usersRoles2);

        Videos video1 = new Videos();
        video1.setName("video 1");
        video1.setUserId(1L);
        video1.setId(1L);
        videosMapper.insert(video1);
        Videos video2 = new Videos();
        video2.setUserId(1L);
        //video2.setName("影片2");
        video2.setName("video 2");
        video2.setId(2L);
        videosMapper.insert(video2);
    }
    @Test
    public void findByEmail() throws Exception {
        User user = userService.findByEmail("111@qq.com");
        assertNotNull(user);

        List<Videos> videos = user.getVideos();
        for(Videos v : videos) {

        }
        List<UsersRoles> list = user.getUserRoles();
        assertThat(list).hasSize(2);

        for(UsersRoles ur : list) {
            //assertNotNull(ur);
            ur.getUser();
        }
    }

}