package com.example.demo1.controller;

import com.example.demo1.entity.UserInfo;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public List<UserInfo> list(){
        List<UserInfo> list = userService.getList();
        return list;
    }

    @RequestMapping("insert")
    public String insert(@RequestBody UserInfo userInfo){
        userService.insert(userInfo);
        return "0";
    }

    @RequestMapping("delete")
    public String delete(String id){
        userService.delete(id);
        return "0";
    }

    @RequestMapping("update")
    public String delete(@RequestBody UserInfo userInfo){
        userService.update(userInfo);
        return "0";
    }

    @RequestMapping("query")
    public List<UserInfo> query(@RequestBody UserInfo userInfo){
        return userService.query(userInfo);
    }

    @RequestMapping("query1")
    public List<UserInfo> query1(@RequestBody UserInfo userInfo){
        return userService.query1(userInfo);
    }

}
