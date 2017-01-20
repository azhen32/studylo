package com.azhen.service;

import com.azhen.domain.UsersRoles;

import java.util.List;

/**
 * Created by azhen on 17-1-20.
 */
public interface UserRoleService {
    List<UsersRoles> find(Long userId);
}
