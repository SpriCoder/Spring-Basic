package com.njuzhy.demo.service;

import com.njuzhy.demo.data.User;
import com.njuzhy.demo.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void save() {
        User user = new User();
        LocalDateTime now = LocalDateTime.now();
        user.setUsername(now.toString());
        user.setPassword("123456");
        assertEquals(true, userService.save(user));
    }

    @Test
    void login() {
        UserVO userVO = userService.login("admin", "123456");
        assertNotNull(userVO);
        assertEquals(1, userVO.getUid());
        userVO = userService.login("admin", "123456_error");
        assertNull(userVO);
        userVO = userService.login("admin_error", "123456");
        assertNull(userVO);
    }
}