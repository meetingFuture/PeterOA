package com.peter.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseUtilsTest {

    @Test
    public void toJsonString() {
        ResponseUtils utils = new ResponseUtils();
        System.out.println(utils.toJsonString());
    }

    @Test
    public void toJsonString1() {
        ResponseUtils utils = new ResponseUtils("LoginException", "error");
        System.out.println(utils.toJsonString());
    }
}