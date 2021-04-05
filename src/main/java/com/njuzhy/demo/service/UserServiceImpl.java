package com.njuzhy.demo.service;

import com.njuzhy.demo.dao.UserDao;
import com.njuzhy.demo.data.User;
import com.njuzhy.demo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author stormbroken
 * Create by 2021/04/05
 * @Version 1.0
 **/

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        boolean result = false;
        try{
            result = userDao.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return result;
    }

    /**
     * 用户登录
     *
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserVO login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if(user == null || !password.equals(user.getPassword())){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
