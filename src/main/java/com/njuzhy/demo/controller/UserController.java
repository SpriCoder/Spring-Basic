package com.njuzhy.demo.controller;

import com.njuzhy.demo.data.User;
import com.njuzhy.demo.form.LoginForm;
import com.njuzhy.demo.form.UserForm;
import com.njuzhy.demo.service.UserService;
import com.njuzhy.demo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author stormbroken
 * Create by 2021/04/05
 * @Version 1.0
 **/

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public boolean register(@RequestBody UserForm userForm){
        System.out.println(userForm.toString());
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        return userService.save(user);
    }

    @PostMapping("/login")
    public UserVO login(@RequestBody LoginForm loginForm){
        System.out.println(loginForm.toString());
        return userService.login(loginForm.getUsername(), loginForm.getPassword());
    }
}
