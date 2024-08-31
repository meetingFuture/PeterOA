package com.peter.oa.utils;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.apache.commons.codec.digest.DigestUtils;

public class Md5Utils {
    public String md5Digest(String source){
        String md5 = DigestUtils.md5Hex(source);
        return md5;
    }

    public String md5Digest(String source, Integer salt){

        char[] chars = source.toCharArray();

        for(int i=0; i<chars.length; i++){
            chars[i] = (char)(chars[i] + salt);
        }
        String new_source = new String(chars);
        return DigestUtils.md5Hex(new_source);
    }
}
