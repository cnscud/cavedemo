package com.cnscud.cavedemo.gateway.exceptionhandler;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

//@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes{

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Throwable error = super.getError(request);

        Map<String, Object> map = super.getErrorAttributes(request, options);
        map.put("status", HttpStatus.BAD_REQUEST.value());
        map.put("message", error.getMessage());
        return map;
    }


}