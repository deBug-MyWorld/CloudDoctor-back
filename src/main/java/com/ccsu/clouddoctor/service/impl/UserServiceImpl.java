package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.UserMapper;
import com.ccsu.clouddoctor.pojo.User;
import com.ccsu.clouddoctor.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //service层调dao层
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User queryUserByUname(String username) {
        return userMapper.queryUserByUname(username);
    }

    @Override
    public int updateUserByUname(User user) {
        return userMapper.updateUserByUname(user);
    }

    @Override
    public int updateIcon(String url, String username) {
        return userMapper.updateIcon(url,username);
    }

    @Override
    public int updatePassWord(String password, String username) {
        return userMapper.updatePassWord(password,username);
    }

    @Override
    public int updateMoney(String username, double money) {
        return userMapper.updateMoney(username,money);
    }

    @Override
    public PageInfo<User> queryAllUser(int pageNum,int pageSize) {
        Page<Object> page=PageHelper.startPage(pageNum,pageSize);
        List<User>list = userMapper.queryAllUser();
        PageInfo<User>info = new PageInfo<>(list);
        return info;
    }

    @Override
    public int updateUserByAdmin(User user) {
        return userMapper.updateUserByAdmin(user);
    }

    @Override
    public int deleteUserByAdmin(int id) {
        return userMapper.deleteUserByAdmin(id);
    }
}
