package com.cnscud.cavedemo.gateway.circuitbreaker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/defaultfallback")
    public Map<String,Object> defaultfallback(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",5001);
        map.put("msg","服务异常");
        return map;
    }

}
