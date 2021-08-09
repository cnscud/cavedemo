package com.cnscud.cavedemo.fundmain.controller;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试异常.
 *
 * @author Felix Zhang 2021-08-09 10:11
 * @version 1.0.0
 */
@RestController
@RequestMapping("/exception")
public class TestExceptionController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/random")
    public String randomException(HttpServletRequest request) throws Exception{

        request.getParameterMap();

        int a = RandomUtils.nextInt(3);
        if(a == 1){

            logger.warn("throw a Exception!");

            throw new Exception("Random Exception");
        }

        logger.info("no exception, normal response");
        return "not exception";
    }

    @RequestMapping("/must")
    public String mustException(HttpServletRequest request) throws Exception{
            throw new Exception("Must Exception");
    }

    @RequestMapping("/longtimeout")
    public String longTimeout(HttpServletRequest request) throws Exception{

        logger.info("call longtimeout...");
        Thread.sleep(5000);

        return "ok";
    }

    @RequestMapping("/smalltimeout")
    public String smallTimeout(HttpServletRequest request) throws Exception{

        logger.info("call smalltimeout...");
        Thread.sleep(1000);

        return "ok";
    }

}
