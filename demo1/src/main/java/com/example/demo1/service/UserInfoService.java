package com.example.demo1.service;

import com.example.demo1.entity.User;
import com.example.demo1.entity.UserExample;
import com.example.demo1.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> getList();

    void insert(UserInfo userInfo);

    void delete(String id);

    void update(UserInfo userInfo);

    List<UserInfo> query(UserInfo userInfo);

    List<UserInfo> query1(UserInfo userInfo);

}
