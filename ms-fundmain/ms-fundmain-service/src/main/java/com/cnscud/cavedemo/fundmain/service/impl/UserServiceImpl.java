package com.cnscud.cavedemo.fundmain.service.impl;

import com.cnscud.cavedemo.fundmain.dao.UserDao;
import com.cnscud.cavedemo.fundmain.model.User;
import com.cnscud.cavedemo.fundmain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Service Impl.
 *
 * @author Felix Zhang 2021-08-02 15:29
 * @version 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUser(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public User queryUserByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public int createUser(User user) {
        return userDao.insert(user);
    }
}
