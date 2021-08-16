package com.cnscud.cavedemo.fundmain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理.
 *
 * @author Felix Zhang 2021-08-10 10:52
 * @version 1.0.0
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> errorHandler(Exception ex, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 99);
        map.put("msg", ex.getMessage());
        return map;
    }

    //可以针对各种异常定制错误信息... 特别是数据库异常 要避免泄露SQL


}
