package com.azhen.service.impl;

import com.azhen.domain.User;
import com.azhen.domain.UserExample;
import com.azhen.mapper.UserMapper;
import com.azhen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by azhen on 17-1-10.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
   @Autowired
    private UserMapper userMapper;

    public Integer save(User user) {
        System.out.println("save");
        return userMapper.insert(user);
    }

    public User find(String nickName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNicknameEqualTo(nickName);
        List<User> list = userMapper.selectByExample(example);
        if(list != null && list.size() > 0) {
            User user = list.get(0);
            return user;
        }
        return null;
    }

    public User findByEmail(String email) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> list = userMapper.selectByExample(example);
        if(list != null && list.size() > 0) {
            User user = list.get(0);
            return user;
        }
        return null;
    }

    public User findByEmailAll(String email) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> list = userMapper.selectByExampleAll(example);
        if(list != null && list.size() > 0) {
            User user = list.get(0);
            return user;
        }
        return null;
    }

    public boolean hasMatchUser(String nickname, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNicknameEqualTo(nickname).andPasswordEqualTo(password);
        List<User> list = userMapper.selectByExample(example);
        if(list != null && list.size() == 1) {
           return true;
        }
        return false;
    }

    public User get(Long id) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> list = userMapper.selectByExample(example);
        if(list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
