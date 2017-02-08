package com.azhen.controller;

import com.azhen.domain.Authorities;
import com.azhen.dto.EUTreeNode;
import com.azhen.dto.Result;
import com.azhen.exception.BaseException;
import com.azhen.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 权限Controller
 */
@Controller
@RequestMapping("/user/role/authority")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    /**
     * 根据父分类ID查询子分类Id
     * @param parentId
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getAuthList(@RequestParam(value="id",defaultValue="0") Long parentId) {
        return authorityService.getAuthList(parentId);
    }

    /**
     * 新增权限
     * @param auth
     * @return
     */
    @RequestMapping("/create")
    @ResponseBody
    public Result create(Authorities auth) {
        Authorities result = authorityService.save(auth);
        return Result.ok(result);
    }

    /**
     * 修改权限名
     * @param auth
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public Result update(Authorities auth) {
        Integer result = authorityService.update(auth);
        if(1 != result) {
            return Result.error();
        }
        return Result.ok();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Authorities auth) {
        Integer result = authorityService.delete(auth);
        if(1 != result) {
            return Result.error();
        }
        return Result.ok();
    }
}
