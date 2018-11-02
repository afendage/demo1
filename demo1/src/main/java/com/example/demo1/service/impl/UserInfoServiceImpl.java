package com.example.demo1.service.impl;

import com.example.demo1.entity.User;
import com.example.demo1.entity.UserInfo;
import com.example.demo1.mapper.UserInfoMapper;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> getList() {
        return userInfoMapper.getList();
    }

    @Override
    public void insert(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void delete(String id) {
        userInfoMapper.delete(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoMapper.update(userInfo);
    }

    @Override
    public List<UserInfo> query(UserInfo userInfo) {
        return userInfoMapper.query(userInfo);
    }

    @Override
    public List<UserInfo> query1(UserInfo userInfo) {
        return userInfoMapper.query1(userInfo);
    }

}
