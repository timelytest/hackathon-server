package com.timelytest.hackathon.serviceImpl;

import com.timelytest.hackathon.bean.RegisterBean;
import com.timelytest.hackathon.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Before
    public void init(){}

    @Test
    public void testUser() {
        assertEquals("FAIL", userService.login("abcd@email.nju.edu.cn", "123"));
        RegisterBean registerBean = new RegisterBean("abc@email.nju.edu.cn", "test01", "123456", "NJU", "161250001", "大三", "软件工程");
        userService.register(registerBean, "/card/test");
        assertEquals("EXIST", userService.register(registerBean, ""));
        assertEquals("FAIL", userService.login("abc@email.nju.edu.cn", "123"));
        assertEquals("SUCCESS", userService.login("abc@email.nju.edu.cn", "123456"));
    }
}