package com.wxss.springbootdemo.utils;

import java.security.MessageDigest;

/**
 * Author:Created by wx on 2019/8/14
 * Desc:
 */
public class Md5Utils {
    public static final String MD5Encoder(String str, String charset) {
        // 确定计算方法
        MessageDigest md5;
        String newstr = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes(charset));
            newstr = byte2HexStr(md5.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newstr;
    }
    /**
     * 将二进制转换16进制
     *
     * @param buf
     * @return
     */
    private static String byte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toLowerCase());
        }
        return sb.toString();
    }
}
