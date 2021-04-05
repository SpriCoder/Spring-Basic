package com.njuzhy.demo.service;

import com.njuzhy.demo.data.User;
import com.njuzhy.demo.vo.UserVO;

/**
 * @Author stormbroken
 * Create by 2021/04/05
 * @Version 1.0
 **/

public interface UserService {
    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 用户登录
     *
     *
     * @param username
     * @param password
     * @return
     */
    UserVO login(String username, String password);
}
