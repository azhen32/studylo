package com.azhen.controller;

import com.azhen.dto.EUDataGridResult;
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

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult list() {
        return null;
    }
}
