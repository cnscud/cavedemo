package com.cnscud.cavedemo.web.feign;

import com.cnscud.cavedemo.fundmain.model.User;
import com.cnscud.cavedemo.fundmain.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign client.
 *
 * @author Felix Zhang 2021-08-07 15:43
 * @version 1.0.0
 */
@FeignClient(value = "ms-fundmain-service", contextId = "user")
@RequestMapping("/user")
public interface UserServiceClient {

    @RequestMapping("/queryById")
    public User queryUser(int id);

    @RequestMapping("/queryByUsername")
    public User queryUserByUserName(String username);

}
