package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.service.UserService;
import com.example.demo1.system.config.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.util.Date;

@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("insert")
    public int insert(@RequestBody User user){
        return userService.insert(user);
    }

    @RequestMapping(value = "save")
    public int save(HttpServletRequest request, @RequestBody User user){
        if(null == user.getId()){
            user.setCreateuser("1");
            user.setCreatetime(new Date());
            return userService.insert(user);
        }else{
            User u = (User) request.getSession().getAttribute(WebSecurityConfig.SESSION_KEY);
            user.setUpdateuser(u.getId().toString());
            user.setUpdatetime(new Date());
            return userService.updateByPrimaryKey(user);
        }
    }

}
