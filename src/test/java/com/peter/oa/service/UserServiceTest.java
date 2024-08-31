package com.peter.oa.service;

import com.peter.oa.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void checkLogin() {
        UserService userService = new UserService();
        User user = userService.checkLogin("m8", "test1");
        System.out.println(user.toString());
    }

    @Test
    public void checkLogin2() {
        UserService userService = new UserService();
        User user = userService.checkLogin("m8", "test");
        System.out.println(user.toString());
    }
}