package com.peter.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MybatisUtilsTest {

    @Test
    public void executeSql() {
        String s = (String) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        System.out.println(s);
    }
}