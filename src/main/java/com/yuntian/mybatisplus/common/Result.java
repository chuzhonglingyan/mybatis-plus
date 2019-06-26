package com.yuntian.mybatisplus.common;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class Result<T> {

    private int code;

    /**
     * 失败状态
     **/
    public static final Integer FAIL = 0;
    /**
     * 成功状态
     **/
    public static final Integer SUCCESS = 1;


    private Integer state;

    private boolean success;

    private String message;

    private T data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }



    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Result setState(Integer state) {
        this.state = state;
        return  this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return  this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
