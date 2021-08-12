package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.xpower.cache.IRedisCluster;
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


        //IRedis redis = RedisAutoConfigCacheFactory.getInstance().getCache("redis.test");
        //redis.delete(key);
        //redis.setString(key, "hello single redis - " + LocalDateTime.now());

        IRedisCluster rediscluster = RedisClusterAutoConfigCacheFactory.getInstance().getCache("redis.cluster.test");
        //redis.delete(key);
        rediscluster.setString(key, "hello cluster redis - " + LocalDateTime.now());

        return  " " + rediscluster.getString(key);
    }
}
