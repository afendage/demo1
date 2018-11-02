package com.example.demo1.mapper;

import com.example.demo1.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> getList();

    void insert(UserInfo userInfo);

    void delete(String id);

    void update(UserInfo userInfo);

    List<UserInfo> query(UserInfo userInfo);

    @Select("select * from user where id =#{id}")
    List<UserInfo> query1(UserInfo userInfo);

}