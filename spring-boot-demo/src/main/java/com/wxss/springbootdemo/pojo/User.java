package com.wxss.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Author:Created by wx on 2019/8/14
 * Desc:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "user")
public class User {
//    private Long uid;
    private String username;
    private String password;
    private String[] roles;
}
