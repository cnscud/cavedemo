package com.cnscud.cavedemo.fundmain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * External Fallback Demo.
 *
 * @author Felix Zhang 2021-08-16 18:30
 * @version 1.0.0
 */
@RestController
public class ExternalFallback {

    private static final Logger logger = LoggerFactory.getLogger(ExternalFallback.class);


    //private static final String EXECUTION_EXCEPTION_TYPE = "Execution-Exception-Type";
    //private static final String EXECUTION_EXCEPTION_MESSAGE = "Execution-Exception-Message";

    private static final String ROOT_CAUSE_EXCEPTION_TYPE = "Root-Cause-Exception-Type";
    private static final String ROOT_CAUSE_EXCEPTION_MESSAGE = "Root-Cause-Exception-Message";

    private static final String EXECUTION_EXCEPTION_TYPE = "Exception-Type";
    private static final String EXECUTION_EXCEPTION_MESSAGE = "Exception-Message";

    @RequestMapping("/externalfallback")
    @ResponseStatus
    public Map<String, Object> externalfallback(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        map.put("code", 5002);
        map.put("msg", "服务异常");

        map.put(EXECUTION_EXCEPTION_TYPE, request.getHeader(EXECUTION_EXCEPTION_TYPE));
        map.put(EXECUTION_EXCEPTION_MESSAGE, request.getHeader(EXECUTION_EXCEPTION_MESSAGE));

        return map;
    }
}
