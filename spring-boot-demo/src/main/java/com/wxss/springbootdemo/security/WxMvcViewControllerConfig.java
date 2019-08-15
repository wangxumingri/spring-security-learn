package com.wxss.springbootdemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WxMvcViewControllerConfig implements WebMvcConfigurer {

    /**
     * 视图控制：url与视图映射
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/testUser").setViewName("testUser");
        registry.addViewController("/testAdmin").setViewName("testAdmin");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logsuccess").setViewName("logsucessful");
    }

}
