package com.bj.hai.yang.blog.start.common.utils;

import com.twmacinta.util.MD5;

public class MD5Utils {
    public static String encryption(String pwd) {
        MD5 md5 = new MD5(pwd);
        return md5.asHex();
    }

}
