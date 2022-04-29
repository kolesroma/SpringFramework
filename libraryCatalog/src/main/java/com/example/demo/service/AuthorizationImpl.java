package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationImpl implements Authorization {
    private final UserDao userDao;

    @Autowired
    public AuthorizationImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String login, String password) {
        return userDao.getByLoginPassword(login, password);
    }
}
