package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.xpower.configcenter.SystemConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Echo for demo.
 *
 * @author Felix Zhang 2021-08-02 16:07
 * @version 1.0.0
 */
@RestController
public class EchoController {

    @RequestMapping("/echo")
    public String echo(String name) {
        return "Echo " + name;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello" ;
    }

    @RequestMapping("/config")
    public String config(String key){
        return SystemConfig.getInstance().getString(key, "not found");
    }

}
