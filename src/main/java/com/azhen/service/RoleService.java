package com.azhen.service;

import com.azhen.domain.Roles;
import com.azhen.dto.EUDataGridResult;
import com.azhen.dto.Result;

/**
 * Created by azhen on 17-2-4.
 */
public interface RoleService {

    EUDataGridResult getRoleList(Integer page, Integer rows);

    /**
     * 新建角色
     * @param ids
     * @param name
     * @return
     */
    Roles save(String ids, String name);
}
