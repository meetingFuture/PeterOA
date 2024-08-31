package com.peter.oa.mapper;

import com.peter.oa.entity.User;
import com.peter.oa.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserMapper {
    public User selectByUsername(String username) {
        User user = (User)MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername", username));
        return user;
    }
}
