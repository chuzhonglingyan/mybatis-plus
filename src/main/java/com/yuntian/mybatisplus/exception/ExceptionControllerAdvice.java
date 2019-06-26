package com.yuntian.mybatisplus.exception;//package com.company.project.exception;

import com.alibaba.fastjson.JSON;
import com.yuntian.mybatisplus.common.Result;
import com.yuntian.mybatisplus.common.ResultGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;


/* @ Author     ：guangleilei.
 * @ Date       ：Created in 10:46 2018/11/13
 * @ Description：${只有当api接口和自定义异常在一个包下面的时候，消费端才会抛出生产者抛出的异常，否则消费端抛出dubbo封装的异常。 }
 */
@RestControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    /**
     * 拦截捕捉自定义异常 BusinessException.class
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public Result bussExceptionHandler(BusinessException e) {
        Result result = ResultGenerator.genFailResult(e.getCode(), e.getMessage());
        log.error(JSON.toJSONString(result));
        return result;
    }


    @ExceptionHandler({Exception.class})
    public Result handlerException(Exception ex) {
        log.error("发生未知异常：{}", ex);
        return ResultGenerator.genFailResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器打了个小盹儿~请稍候再试");
    }

}
