package com.njuzhy.demo.dao;

import com.njuzhy.demo.data.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    void save() {
        User user = new User();
        LocalDateTime now = LocalDateTime.now();
        user.setUsername(now.toString());
        user.setPassword("123456");
        assertEquals(true, userDao.save(user));
    }

    @Test
    void getUserByUsername() {
        assertNotNull(userDao.getUserByUsername("admin"));
    }
}