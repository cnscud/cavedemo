package com.cnscud.cavedemo.fundmain.controller;

import com.cnscud.cavedemo.fundmain.model.User;
import com.cnscud.cavedemo.fundmain.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 数据库异常+事务.
 *
 * @author Felix Zhang 2021-08-13 10:34
 * @version 1.0.0
 */
@RestController
@RequestMapping("/dbexception")
@Transactional
public class TestDbExceptionController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;


    @RequestMapping("/adduser")
    public String addUserWithException(){

        logger.warn("call add User with Exception!");

        User user = new User();
        user.setUsername("test");
        user.setName("Test");
        user.setSalt("test");

        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setIntroduce("Hello Test");
        //此处逻辑错误, 仅为示意
        user.setPassword("badpassword");

        int result = userService.createUser(user);

        //故意抛出异常
        int a = 1/0;

        return "" + result;
    }
}
