package com.njuzhy.demo.dao;

import com.njuzhy.demo.data.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author stormbroken
 * Create by 2021/04/05
 * @Version 1.0
 **/

@Mapper
public interface UserDao {
    /**
     * 存储一个用户
     *
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}
