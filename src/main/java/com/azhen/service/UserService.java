package com.azhen.service;

import com.azhen.domain.User;
import com.azhen.dto.Result;

/**
 * Created by azhen on 17-1-10.
 */
public interface UserService {
    Integer save(User user);

    User find(String nickName);
    User findByEmail(String email);
    User findByEmailAll(String email);

    boolean hasMatchUser(String nickname, String password);

    User get(Long id);
}