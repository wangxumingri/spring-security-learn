package com.wxss.springbootdemo.exception;

import com.wxss.springbootdemo.pojo.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Author:Created by wx on 2019/8/14
 * Desc:
 */
@RestControllerAdvice
public class WxExceptionHandler {

    @ExceptionHandler(WxSecurityException.class)
    public BaseResponse handlerCustomerException(WxSecurityException e){
        return new BaseResponse(70001,e.getErrMessage());
    }
}
