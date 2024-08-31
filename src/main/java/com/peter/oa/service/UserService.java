package com.peter.oa.service;

import com.peter.oa.entity.User;
import com.peter.oa.mapper.UserMapper;
import com.peter.oa.service.exception.LoginException;
import com.peter.oa.utils.Md5Utils;

public class UserService {
    public static UserMapper userMapper = new UserMapper();
    public static Md5Utils md5Utils = new Md5Utils();
    public User checkLogin(String username, String password){
        User user = userMapper.selectByUsername(username);
        if(user == null){
            throw new LoginException("User not found");
        }

        String md5Password = md5Utils.md5Digest(password, user.getSalt());
        if(!user.getPassword().equals(md5Password)){
            throw new LoginException("Wrong password");
        }
        user.setPassword(null);
        user.setSalt(null);
        return user;
    }
}
