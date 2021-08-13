package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.xpower.configcenter.ConfigCenter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取Zookeeper 配置, 作为配置中心.
 *
 * @author Felix Zhang 2021-08-03 11:17
 * @version 1.0.0
 */
@RestController
@RequestMapping("/zk")
public class ZookeeperConfigController {

    @RequestMapping("/test")
    public String readSomeConfig(){
        return ConfigCenter.getInstance().getDataAsString("/xpower/config/cavedemo/test");
        //return "";
    }
}
