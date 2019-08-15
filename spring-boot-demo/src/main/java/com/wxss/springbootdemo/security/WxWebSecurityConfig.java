package com.wxss.springbootdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Author:Created by wx on 2019/8/14
 * Desc:
 */
@Configuration
@EnableWebSecurity
public class WxWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("wxUserDetailService")
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

//    @Override
//    protected UserDetailsService userDetailsService() {
//        return super.userDetailsService();
//    }


    @Override
    public void init(WebSecurity web) throws Exception {
        super.init(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 这两个路径不需要认证
                .antMatchers("/", "/home").permitAll()
                // testAdmin要求ADMIN权限
                .antMatchers("/testAdmin").hasRole("ADMIN")
                // testUser要求USER权限
                .antMatchers("/testUser").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout666")
                .logoutSuccessUrl("/logsuccess")
                .permitAll();
    }
}
