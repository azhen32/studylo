package com.azhen.controller;

import com.azhen.domain.User;
import com.azhen.dto.EUDataGridResult;
import com.azhen.dto.Result;
import com.azhen.service.UserService;
import com.azhen.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;

/**
 * Created by azhen on 17-1-10.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    /**
     * 用户启用
     * @return
     */
    @RequestMapping("/enable")
    //@RequestBody
    public Result enableUser(String ids) {
        //userService.batch(String ids);
        return Result.ok();
    }


    /**
     * 用户列表查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getUserList(Integer page,Integer rows) {
        EUDataGridResult result = userService.getUserList(page,rows);
        return result;
    }

    @RequestMapping(value="/store",method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "error";
        }
        Integer status = userService.save(user);
        if(1 != status) {
            return "error";
        }
        return "success";
    }
    @RequestMapping(value="/{id}",method = RequestMethod.POST)
    @ResponseBody
    public String getUserInfo(@PathVariable("id") Long id) {
        User user = userService.get(id);
        if(null != user) {
            JsonUtils.objectToJson(user);
        }
        return JsonUtils.objectToJson(Result.error());
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

}
