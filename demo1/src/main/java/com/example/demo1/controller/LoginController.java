package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.entity.UserExample;
import com.example.demo1.service.UserService;
import com.example.demo1.system.config.WebSecurityConfig;
import com.example.demo1.system.utils.CookieUtil;
import com.example.demo1.system.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginPost")
    @ResponseBody
    public Map<String, Object> loginPost(HttpServletResponse response,String username, String password, HttpSession session) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.createCriteria().andPasswordEqualTo(Md5Util.MD5Encode(password));
        List<User> list = userService.selectByExample(example);

        Map<String, Object> map = new HashMap<>();
        if (null == list) {
            map.put("success", false);
            map.put("message", "账号或密码错误");
            return map;
        }

        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, list.get(0));
        session.setMaxInactiveInterval(30000);

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }

}
