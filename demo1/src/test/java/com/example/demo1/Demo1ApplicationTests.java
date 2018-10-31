package com.example.demo1;

import com.example.demo1.entity.UserInfo;
import com.example.demo1.service.UserService;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println("asdfasdf");
    }

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        UserInfo user =new UserInfo();
        user.setUsername("admin");
        user.setPassword("123456");
        session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }

    @Test
    public void testUserGetList2() throws Exception {
        List<UserInfo> list = userService.getList();
        System.out.println(list.size());
    }

    @Test
    public void testUserGetList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/list")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUserGetList1() throws Exception {
        MvcResult m= mvc.perform(MockMvcRequestBuilders.post("/list")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(m.getResponse().getContentAsString());
    }

    @Test
    public void testUserInsert() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("finger1");
        userInfo.setSex("1");
        userInfo.setPassword("12313666");
        mvc.perform(MockMvcRequestBuilders.post("/insert")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(userInfo))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testUserInsert1() throws Exception{
        UserInfo userInfo = new UserInfo();
        userInfo.setId(3);
        userInfo.setUsername("finger");
        userInfo.setSex("2");
        userInfo.setPassword("12313");
        userService.insert(userInfo);
    }

    @Test
    public void testUserDelete() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/delete")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
                .param("id","5")
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void testUserUpdate() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("romeo");
        userInfo.setSex("1");
        userInfo.setPassword("33333");
        mvc.perform(MockMvcRequestBuilders.post("/update")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(userInfo))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
        ;
    }

    @Test
    public void testUserQuery() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("romeo");
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/query")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(userInfo))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                ;
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testUserQuery1() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/query1")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(userInfo))

        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}
