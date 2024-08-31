package com.peter.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;
public class Md5UtilsTest {
    Md5Utils md5 = new Md5Utils();
    @Test
    public void md5Digest() {
        String md5String = md5.md5Digest("test");
        System.out.println(md5String);
    }

    @Test
    public void testMd5Digest() {
        String md5String = md5.md5Digest("test", 123);
        System.out.println(md5String);
    }
}