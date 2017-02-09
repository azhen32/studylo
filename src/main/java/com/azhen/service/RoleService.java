package com.azhen.service;

import com.azhen.domain.Roles;
import com.azhen.dto.EUDataGridResult;

/**
 * Created by azhen on 17-2-4.
 */
public interface RoleService {

    EUDataGridResult getRoleList(Integer page, Integer rows);
}
