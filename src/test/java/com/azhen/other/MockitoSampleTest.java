package com.azhen.other;

import com.azhen.domain.User;
import com.azhen.mapper.UserMapper;
import com.azhen.service.UserService;
import com.azhen.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by azhen on 17-1-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class MockitoSampleTest {

    @Mock
    UserService mockUserService;

    @Before
    public void initMocks() {
        mockUserService = mock(UserServiceImpl.class);
        MockitoAnnotations.initMocks(this);
    }

    //1.模拟接口UserService测试
    @Test
    public void testMockInterface() {

        //1.对方法设定返回值
        when(mockUserService.find("tom")).thenReturn(new User("tom","1234"));
        //2.对方法设定返回值
        doReturn(true).when(mockUserService).hasMatchUser("tom","1234");
        //3.对void方法进行预期设定
        User u = new User("John","1234");
        doNothing().when(mockUserService).save(u);


        //4.执行方法调用
        User user = mockUserService.find("tom");
        boolean isMatch = mockUserService.hasMatchUser("tom","1234");
        mockUserService.save(user);

        assertNotNull(user);
        assertEquals(user.getNickname(),"tom");
        assertEquals(isMatch,true);

        //5.验证交互行为
        verify(mockUserService).find("tom");
        //6.验证方法至少调用一次
        verify(mockUserService,atLeastOnce()).find("tom");
        verify(mockUserService,atLeast(1)).find("tom");
        verify(mockUserService,atMost(1)).find("tom");
        verify(mockUserService,times(1)).find("tom");
    }

}
