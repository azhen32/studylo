package com.azhen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azhen.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class FreeMarkerController {

    @RequestMapping("/free1")
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("index");
        User user = new User();
        user.setNickname("<h2>小明=========================================================></h2>");
        user.setPassword("<a href='https://www.hao123.com/'>百度</a>");
        List<User> users = new ArrayList<User>();
        users.add(user);
        mav.addObject("user", users);
        return mav;
    }

    @RequestMapping("/index2")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("title", "网站标题");
        //说明：在这里可以控制不生成静态htm
        mav.addObject("CREATE_HTML", false);
        return mav;
    }

    @RequestMapping("/html/index")
    public ModelAndView htmlIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        //默认是生成静态页面的
        modelAndView.addObject("content", "网站标题");
        return modelAndView;
    }

    //jsp测试
    @RequestMapping("/jsp/index")
    public ModelAndView jspindex(){
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("content", "网站标题");
        return modelAndView;
    }
}
