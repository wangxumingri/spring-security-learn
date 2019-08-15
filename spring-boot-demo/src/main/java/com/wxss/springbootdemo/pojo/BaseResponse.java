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
public class BaseResponse {
    private int errCode;
    private String errMessage;
}
