package com.cnscud.cavedemo.gateway.circuitbreaker;

import com.cnscud.cavedemo.gateway.exceptionhandler.GatewayErrorAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.cloud.gateway.support.TimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * Default Fallback.
 *
 * @author Felix Zhang 2021-08-08 17:55
 * @version 1.0.0
 */
@RestController
public class DefaultFallback {

    private static final Logger logger = LoggerFactory.getLogger(GatewayErrorAttributes.class);

    @RequestMapping("/simplefallback")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> defaultfallback() {

        Map<String, Object> map = new HashMap<>();
        map.put("code", 5001);
        map.put("msg", "服务异常");
        return map;
    }

    @RequestMapping(value = "/defaultfallback")
    @ResponseStatus
    public Mono<Map<String, Object>> fallback(ServerWebExchange exchange) {
        Map<String, Object> result = new HashMap<>(4);
        result.put("code", 5001);

        Exception exception = exchange.getAttribute(ServerWebExchangeUtils.CIRCUITBREAKER_EXECUTION_EXCEPTION_ATTR);

        ServerWebExchange delegate = ((ServerWebExchangeDecorator) exchange).getDelegate();
        logger.error("服务调用失败，URL={}", delegate.getRequest().getURI(), exception);

        result.put("uri", delegate.getRequest().getURI());

        if (exception instanceof TimeoutException) {
            result.put("msg", "服务超时");
        }
        else if (exception != null && exception.getMessage() != null) {
            result.put("msg", "服务错误: " + exception.getMessage());
        }
        else {
            result.put("msg", "服务错误");
        }
        return Mono.just(result);
    }
}
