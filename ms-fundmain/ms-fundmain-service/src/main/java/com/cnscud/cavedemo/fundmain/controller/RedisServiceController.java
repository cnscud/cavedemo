package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.xpower.cache.IRedis;
import com.cnscud.xpower.cache.IRedisCluster;
import com.cnscud.xpower.cache.impl.RedisAutoConfigCacheFactory;
import com.cnscud.xpower.cache.impl.RedisClusterAutoConfigCacheFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Redis Demo.
 *
 * @author Felix Zhang 2021-08-04 11:07
 * @version 1.0.0
 */
@RestController
@RequestMapping("/redis")
public class RedisServiceController {

    String key = "cavedemo.test";

    @RequestMapping("/test")
    public String readRedisData() {


        //for local test, for product you should switch to RedisClusterAutoConfigCacheFactory
        IRedis redis = RedisAutoConfigCacheFactory.getInstance().getCache("redis.test");
        redis.delete(key);
        redis.setString(key, "hello single redis - " + LocalDateTime.now());

        //IRedisCluster redis = RedisClusterAutoConfigCacheFactory.getInstance().getCache("redis.cluster.test");
        //redis.delete(key);
        //redis.setString(key, "hello cluster redis - " + LocalDateTime.now());

        return  " " + redis.getString(key);
    }
}
