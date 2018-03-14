package com.cai.blog.common;

/**
 * Created by caiyl on 2017/10/8.
 */
public class Result{
    public static final String SUCCESS_CODE = "0";
    public static final String FAILED_CODE = "1";
    private boolean successFlag;
    private Object message;

    public boolean getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(boolean successFlag) {
        this.successFlag = successFlag;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
