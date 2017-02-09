package com.azhen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/sso")
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(String gotoUrl,String username, String password, HttpServletRequest request,HttpServletResponse response) {
        if(username.equals("AZ") && password.equals("23")) {
            Cookie cookie = new Cookie("sesscookie","sso");
            cookie.setPath("/");    //对localhost域下面所有应用都可见
            response.addCookie(cookie);
        }
       return "redirect:" + gotoUrl;
    }

    @RequestMapping(value = "/loginCheck",method = RequestMethod.GET)
    public String check(HttpServletRequest request,@CookieValue("sesscookie") String ssocookie) {
       if(ssocookie.isEmpty()) {
            return "sso1_index";
       }
        return "ssoLogin";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","test");
        mv.setViewName("error");
        return mv;
    }

}
