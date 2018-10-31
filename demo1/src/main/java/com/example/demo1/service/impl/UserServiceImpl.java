package com.example.demo1.service.impl;

import com.example.demo1.entity.UserInfo;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> getList() {
        return userMapper.getList();
    }

    @Override
    public void insert(UserInfo userInfo) {
        userMapper.insert(userInfo);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userMapper.update(userInfo);
    }

    @Override
    public List<UserInfo> query(UserInfo userInfo) {
        return userMapper.query(userInfo);
    }

    @Override
    public List<UserInfo> query1(UserInfo userInfo) {
        return userMapper.query1(userInfo);
    }

}
