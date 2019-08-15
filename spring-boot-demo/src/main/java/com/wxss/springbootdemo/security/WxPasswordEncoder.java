package com.wxss.springbootdemo.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Author:Created by wx on 2019/8/14
 * Desc:
 */
@Component
public class WxPasswordEncoder implements PasswordEncoder {

    private final String segment = "wxss";
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword+segment;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(encode(rawPassword));
    }
}
