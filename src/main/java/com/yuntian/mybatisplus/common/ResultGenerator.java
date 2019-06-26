package com.yuntian.mybatisplus.common;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setState(Result.SUCCESS)
                .setSuccess(true);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result<>()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setState(Result.SUCCESS)
                .setSuccess(true)
                .setData(data);
    }

    public static Result genFailResult(Integer code,String message) {
        return new Result()
                .setCode(code)
                .setState(Result.FAIL)
                .setSuccess(false)
                .setMessage(message);
    }


    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setState(Result.FAIL)
                .setSuccess(false)
                .setMessage(message);
    }
}
