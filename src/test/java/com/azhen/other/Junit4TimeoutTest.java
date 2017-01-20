package com.azhen.other;

import com.azhen.domain.TUser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by azhen on 17-1-16.
 */

public class Junit4TimeoutTest {
    private TUser tom;
    private TUser john;


    @Before
    public void init() {
        tom = new TUser("tom","1234");
        tom.setCredits(100);
        john = new TUser("john","1234");
        john.setCredits(50);
    }

    @Test
    public void testAssertThat() {
        //1.数值匹配
        assertThat(tom.getCredits(),greaterThan(50));
        assertThat(tom.getCredits(),lessThan(150));
        assertThat(tom.getCredits(),greaterThanOrEqualTo(100));
        assertThat(tom.getCredits(),lessThanOrEqualTo(100));
        //测试所有条件必须都成立
        assertThat(tom.getCredits(),allOf(greaterThan(50),lessThan(150)));
        assertThat(tom.getCredits(),anyOf(greaterThan(50),lessThan(150)));
        //测试无论什么条件都成立
        assertThat(tom.getCredits(),anything());
        //测试变量的值等于指定值
        assertThat(tom.getCredits(),is(100));
        //测试变量的值不等于指定的值
        assertThat(tom.getCredits(),not(50));

        //2.字符串匹配
        String url = "http://www.baobaotao.com";
        assertThat(url,containsString("baobaotao.com"));
        assertThat(url,startsWith("http://"));
        assertThat(url,endsWith(".com"));
        assertThat(url,equalTo("http://www.baobaotao.com"));
        assertThat(url,equalToIgnoringCase("http://www.baobaotao.com"));
        assertThat(url,equalToIgnoringWhiteSpace("http://www.baobaotao.com"));

        //3.集合匹配
        List<TUser> users = new ArrayList();
        users.add(tom);
        users.add(john);
        assertThat(users,hasItem(tom));
        assertThat(users,hasItem(john));

        //4.map匹配
        Map<String,TUser> userMap = new HashMap();
        userMap.put(tom.getUserName(),tom);
        userMap.put(john.getUserName(),john);
        assertThat(userMap,hasEntry(tom.getUserName(),tom));
        assertThat(userMap,hasKey(john.getUserName()));
        assertThat(userMap,hasValue(john));
    }
}
