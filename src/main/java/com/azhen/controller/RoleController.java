package com.azhen.controller;

import com.azhen.dto.EUDataGridResult;
import com.azhen.dto.Result;
import com.azhen.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 角色Controller
 */
@Controller
@RequestMapping("/user/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询角色列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult list(Integer page,Integer rows) {
        EUDataGridResult result = roleService.getRoleList(page,rows);
        return result;
    }

    /**
     * 新增角色
     */
    @RequestMapping("/save")
    @ResponseBody
    public Result save(String authIds,String name) {
        roleService.save(authIds,name);
        return Result.ok();
    }
}
