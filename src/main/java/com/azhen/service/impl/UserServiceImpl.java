package com.azhen.service.impl;

import com.azhen.domain.User;
import com.azhen.domain.UserExample;
import com.azhen.dto.EUDataGridResult;
import com.azhen.mapper.UserMapper;
import com.azhen.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by azhen on 17-1-10.
 */
@Service
public class UserServiceImpl implements UserService{
   @Autowired
    private UserMapper userMapper;

    public Integer save(User user) {
        System.out.println("save");
        return userMapper.insert(user);
    }

    public Integer enable(String ids) {

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

    private Map<String, String> usersData = new ConcurrentHashMap<String, String>();

    public UserServiceImpl(){
        System.out.println("用户数据初始化..开始");
        usersData.put("2", "玄玉");
        usersData.put("3", "我的博客：http://blog.csdn.net/jadyer");
        System.out.println("用户数据初始化..完毕");
    }

    @Override
    @Cacheable(value="myCache", key="'get'+#userNo")
    public String get(String userNo){
        System.out.println("数据库中查到此用户号[" + userNo + "]对应的用户名为[" + usersData.get(userNo) + "]");
        return usersData.get(userNo);
    }

    @CacheEvict(value="myCache", key="'get'+#userNo")
    public void update(String userNo){
        System.out.println("移除缓存中此用户号[" + userNo + "]对应的用户名[" + usersData.get(userNo) + "]的缓存");
    }

    //allEntries为true表示清除value中的全部缓存,默认为false
    @CacheEvict(value="myCache", allEntries=true)
    public void removeAll(){
        System.out.println("移除缓存中的所有数据");
    }
}
