package com.example.demo1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroTest {

    public static void login(String url , String userName,String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(url);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);
        subject.login(usernamePasswordToken);
    }

    @Test
    public void testRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:config/realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang","1");
        subject.login(usernamePasswordToken);
    }

    @Test
    public void testLogin(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:config/shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("wang","456");
        try{
            subject.login(usernamePasswordToken);
            Assert.assertEquals(true,subject.isAuthenticated());
            System.out.println("验证成功==============");
        }catch (Exception e){
            System.out.println("登录失败"+e.getMessage());
        }
        subject.logout();
    }

    @Test
    public void testRole(){
        login("classpath:config/shiro.ini","zhang","123");
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.hasRole("role2")+"================");
        Assert.assertTrue(subject.hasRole("role2"));
    }

    @Test
    public void testPermission(){
        login("classpath:config/shiro.ini","liu","123");
        Subject subject = SecurityUtils.getSubject();
        System.out.println("==============="+subject.isPermitted("user:create"));
        System.out.println("==============="+subject.isPermittedAll("user:create","user:update"));
        System.out.println("==============="+subject.isPermitted("user:delete"));
        Assert.assertTrue(subject.isPermitted("user:create"));
        //断言拥有权限：user:create
        subject.checkPermission("user:create");
    }
}
