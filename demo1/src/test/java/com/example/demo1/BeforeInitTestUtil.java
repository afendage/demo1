package com.example.demo1;

import com.example.demo1.entity.UserInfo;
import org.springframework.mock.web.MockHttpSession;

public class BeforeInitTestUtil {

    public static void setSession(MockHttpSession session){
        UserInfo user =new UserInfo();
        user.setUsername("admin");
        user.setPassword("123456");
        session.setAttribute("user",user);
    }
}
