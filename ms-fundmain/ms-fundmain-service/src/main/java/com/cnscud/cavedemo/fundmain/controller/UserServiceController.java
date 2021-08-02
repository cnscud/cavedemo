package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.cavedemo.fundmain.model.User;
import com.cnscud.cavedemo.fundmain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Service Controller.
 *
 * @author Felix Zhang 2021-08-02 16:45
 * @version 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryById")
    public User queryUser(Integer id){
        return userService.queryUser(id);
    }
}
