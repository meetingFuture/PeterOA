package com.peter.oa.utils;

import org.junit.Test;

public class MybatisUtilsTestor {
    @Test
    public void testCase1(){
        MybatisUtils.executeQuery(sqlsession ->{
            String out = (String)sqlsession.selectOne("test.sample");
            return out;
        });
    }

    @Test
    public void testCase2(){
        String s = (String) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        System.out.println(s);
    }

}

