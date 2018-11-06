package com.example.demo1;

import com.example.demo1.entity.User;
import com.example.demo1.service.UserInfoService;
import com.example.demo1.service.UserService;
import com.example.demo1.system.utils.Md5Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        BeforeInitTestUtil.setSession(session);
    }

    @Test
    public void insertUser() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        User user = new User();
        user.setId(2);
        user.setUsername("romeo");
        String password = Md5Util.MD5Encode("123456");
        user.setPassword(password);
        user.setCreatetime(new Date());
        user.setPhone("8888888");

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/user/insert")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(user))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void t(){
        /*User user = new User();
        user.setId(2);
        user.setUsername("romeo");
        String password = Md5Util.MD5Encode("123456");
        user.setPassword(password);
        userService.insertSelective(user);*/
       /* User user = userService.selectByPrimaryKey(1);
        System.out.println(user.getUsername());*/

        User user = userService.selectByPrimaryKey(1);
        System.out.println(user.getUsername());
    }

}
