package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.cavedemo.fundmain.model.Blog;
import com.cnscud.cavedemo.fundmain.model.User;
import com.cnscud.cavedemo.fundmain.service.BlogService;
import com.cnscud.cavedemo.fundmain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Service Controller.
 * 用户服务.
 *
 * @author Felix Zhang 2021-08-02 16:45
 * @version 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;



    @RequestMapping("/queryById")
    public User queryUser(Integer id){
        User user = userService.queryUser(id);
        return user;
    }


    @RequestMapping("/queryByUsername")
    public User queryUserByUsername(String username) {
        return userService.queryUserByUsername(username);
    }

}
