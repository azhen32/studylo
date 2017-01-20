package com.azhen.controller;

import com.azhen.domain.User;
import com.azhen.dto.Result;
import com.azhen.service.UserService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by azhen on 17-1-16.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-dao.xml,classpath:spring/applicationContext-trans.xml")
public class UserControllerTest implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    UserService userServiceBean = null;
    UserController userControllerBean = null;

    private MockMvc mockMvc;
    @Autowired
    private  UserService userService;
    @Autowired
    private UserController userController;

    /**
     * @Mock
     * @Autowired
     * service是mock
     */
    /**
     * @Mock
     * service是mock
     */
    /**
     * @InjectMocks
     * @Autowired
     * service是真实的
     */
    @InjectMocks
    @Autowired
    private UserService mockUserService;

    /**
     * @InjectMocks
     * controller是mock，注入的service也是mock
     */

    /**
     *  @InjectMocks
     *  @Autowired
     *  controller是真的，注入的service是mock
     */
    @InjectMocks
    @Autowired
    private UserController mockUserController;

    @Before
    public void before() throws Exception {
        userServiceBean = (UserService) applicationContext.getBean("userService");
        userControllerBean = (UserController) applicationContext.getBean("userController");
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(mockUserController).build();
    }

    @Ignore //设置了Ignore的方法单独测试总会成功
    @Test
    @Transactional  //直接调用的情况下在Web层也可以回滚
    public void save() throws Exception {
        User user = new User("azhen","1234");
        user.setUpdateTime(new Date());
       /* Result result = userController.save(user);
        int status = result.getStatus();
        assertEquals(200,status);*/

    }

    @Test
    //mock了之后，是不会调用下层真实方法的
    public void saveMock() throws Exception {
        System.out.println(userServiceBean == mockUserService);
        System.out.println(userControllerBean == mockUserController);
        System.out.println(mockUserController.getUserService() == userServiceBean);
        System.out.println(mockUserController.getUserService() == mockUserService);
        User user = new User("azhen","1234");
        user.setUpdateTime(new Date());
        when(mockUserService.save(user)).thenReturn(1);
        /*Result result = mockUserController.save(user,null);
        int status = result.getStatus();
        assertEquals(200,status);*/


     /*   Mockito.reset(mockUserService);
        result = mockUserController.save(user);
        status = result.getStatus();
        assertEquals(200,status);*/
    }
    @Ignore
    @Test
    public void getUserInfo() throws Exception {
        Long userId = 1L;
        String userName = "tom";
        String userPassword = "1234";

        User user = new User();
        user.setId(userId);
        user.setNickname(userName);
        user.setPassword(userPassword);
        when(mockUserService.get(userId)).thenReturn(user);

        mockMvc.perform(post("/user/{id}", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(userId))
                .andExpect(jsonPath("nickname").value(userName))
                .andExpect(jsonPath("password").value(userPassword));

        verify(mockUserService).get(userId);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}