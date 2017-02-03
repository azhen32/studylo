package com.azhen.ehcache;

import com.azhen.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by azhen on 17-2-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})
public class TestEhCache {
    @Autowired
    private UserService userService;

    @Test
    public void testCacheable() {
        System.out.println(userService.get("2"));
        System.out.println(userService.get("3"));
        System.out.println(userService.get("2"));
        System.out.println(userService.get("3"));
    }
}
