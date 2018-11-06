package com.example.demo1;

import com.example.demo1.entity.Operation;
import com.example.demo1.service.OperationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MenuTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Autowired
    private OperationService operationService;

    @Before
    public void before(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        BeforeInitTestUtil.setSession(session);
    }

    @Test
    public void insertMenu(){
        Operation operation = new Operation();
        operation.setCode("goods");
        operation.setName("商品管理");
        operation.setUrl("goods");
        operation.setCreateuser("1");
        operation.setCreatetime(new Date());
        operationService.insert(operation);
    }

}
