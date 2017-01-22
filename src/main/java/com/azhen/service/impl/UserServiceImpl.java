package com.azhen.service.impl;

import com.azhen.domain.User;
import com.azhen.domain.UserExample;
import com.azhen.dto.EUDataGridResult;
import com.azhen.mapper.UserMapper;
import com.azhen.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public Integer enable(String ids) {
        userMapper.
        return null;
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

    public EUDataGridResult getUserList(Integer page, Integer rows) {
        UserExample example = new UserExample();
        PageHelper.startPage(page,rows);
        List<User> list = userMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);

        PageInfo<User> pageInfo = new PageInfo<User>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
