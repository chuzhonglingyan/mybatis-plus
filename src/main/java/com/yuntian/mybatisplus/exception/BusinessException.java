package com.yuntian.mybatisplus.exception;

import java.io.Serializable;

/**
 * @Auther: yuntian
 * @Date: 2019/2/16 0016 14:26
 * @Description: 业务异常处理类
 */
public class BusinessException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = 7984725909902168809L;

    private String msg;
    private int code = 500;

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BusinessException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BusinessException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public static void throwMessage(String msg){
        throwMessage(500,msg);
    }

    public static void throwMessage(int code,String msg){
        throw new BusinessException(code,msg);
    }
}
