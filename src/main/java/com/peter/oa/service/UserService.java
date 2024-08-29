package com.peter.oa.service;

import com.peter.oa.entiry.User;
import com.peter.oa.mapper.UserMapper;
import com.peter.oa.service.exception.LoginException;

public class UserService {
    private UserMapper userMapper = new UserMapper();
    public User checkLogin(String username, String password){
        User user = userMapper.selectByUsername(username);
        if(user == null||(!password.equals(user.getPassword()))){
            throw new LoginException("Username or password is incorrect");
        }
        return user;
    }
}
