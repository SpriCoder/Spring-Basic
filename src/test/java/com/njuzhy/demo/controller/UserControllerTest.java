package com.njuzhy.demo.controller;

import com.njuzhy.demo.form.LoginForm;
import com.njuzhy.demo.form.UserForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    MyRequestTemplate myRequestTemplate;

    @Test
    void register() throws Exception{
        UserForm userForm = new UserForm();
        LocalDateTime now = LocalDateTime.now();
        userForm.setUsername(now.toString());
        userForm.setPassword("123456");
        String result = myRequestTemplate.postTemplate("/user/register", userForm);
        assertEquals("true", result);
    }

    @Test
    void login() throws Exception{
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("admin");
        loginForm.setPassword("123456");
        String result = myRequestTemplate.postTemplate("/user/login", loginForm);
        assertEquals("{\"uid\":1,\"username\":\"admin\"}", result);

        loginForm.setUsername("admin_error");
        loginForm.setPassword("123456");
        result = myRequestTemplate.postTemplate("/user/login", loginForm);
        assertEquals(0, result.trim().length());

        loginForm.setUsername("admin");
        loginForm.setPassword("123456_error");
        result = myRequestTemplate.postTemplate("/user/login", loginForm);
        assertEquals(0, result.trim().length());
    }
}