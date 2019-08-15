package com.wxss.springbootdemo.security;

import com.wxss.springbootdemo.exception.WxSecurityException;
import com.wxss.springbootdemo.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:Created by wx on 2019/8/14
 * Desc:
 */
@Component
public class WxUserDetailService implements UserDetailsService {

    @Autowired
    private WxPasswordEncoder passwordEncoder;


    private static final Logger LOG = LoggerFactory.getLogger(WxUserDetailService.class);
    private static Map<String, User> userMap = new HashMap<>();

    static {
        // 模拟数据库
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setRoles(new String[]{"ADMIN"});
        userMap.put(user.getUsername(), user);

        user = new User();
        user.setUsername("supadmin");
        user.setPassword("supadmin");
        user.setRoles(new String[]{"ADMIN", "USER"});
        userMap.put(user.getUsername(), user);

        user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setRoles(new String[]{"USER"});
        userMap.put(user.getUsername(), user);


    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            throw new WxSecurityException("用户名不能为空");
        }
        User loginUser = userMap.get(username);

        if (loginUser == null) {
            throw new WxSecurityException("用户不存在");
        }

        String password = passwordEncoder.encode(loginUser.getPassword());
        String[] roles = loginUser.getRoles();
        if (roles.length<1){
            throw new WxSecurityException("权限不足");
        }

        return new org.springframework.security.core.userdetails.User(username, password,
                AuthorityUtils.createAuthorityList(roles));
    }

}
