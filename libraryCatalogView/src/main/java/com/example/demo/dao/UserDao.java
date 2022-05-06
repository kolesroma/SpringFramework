package com.example.demo.dao;

import com.example.demo.dao.entity.User;

public interface UserDao {
    User getByLoginPassword(String login, String password);
}
