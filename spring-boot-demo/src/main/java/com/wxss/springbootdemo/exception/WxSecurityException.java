package com.wxss.springbootdemo.exception;

/**
 * Author:Created by wx on 2019/8/14
 * Desc:
 */
public class WxSecurityException extends RuntimeException{
    private String errMessage;

    public WxSecurityException() {
    }

    public WxSecurityException( String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
