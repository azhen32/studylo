package com.azhen.service;

import com.azhen.domain.RolesAuthorities;

import java.util.List;

public interface RoleAuthorityService {
    List<RolesAuthorities> getByRoleId(Long roleId);
}
