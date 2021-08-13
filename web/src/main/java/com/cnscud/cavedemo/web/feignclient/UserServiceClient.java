package com.cnscud.cavedemo.web.feignclient;

import com.cnscud.cavedemo.fundmain.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client.
 *
 * @author Felix Zhang 2021-08-07 15:43
 * @version 1.0.0
 */
@FeignClient(value = "ms-gateway", contextId = "user")
@RequestMapping("/fundmain/user")
public interface UserServiceClient {

    @RequestMapping("/queryById")
    public User queryUser(@RequestParam("id") int id);

    @RequestMapping("/queryByUsername")
    public User queryUserByUserName(@RequestParam("username")String username);

}
