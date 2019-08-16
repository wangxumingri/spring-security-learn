package com.wxss.springbootdemo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Author:Created by wx on 2019/8/16
 * Desc:
 */
@Controller
@RequestMapping("/show")
public class LoginController {

    @RequestMapping("/username1")
    @ResponseBody
    public String showUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 区分匿名用户和已登录用户
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }else {
            return "游客";
        }
    }

    @RequestMapping(value = "/username2", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }

    @RequestMapping(value = "/username3", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }


    @RequestMapping(value = "/username4", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @RequestMapping(value = "/username5", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(@AuthenticationPrincipal User user){
        return user.getUsername();
    }
}
