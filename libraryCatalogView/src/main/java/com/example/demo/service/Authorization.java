package com.example.demo.service;

import com.example.demo.dao.entity.User;

public interface Authorization {
    User login (String login, String password);
}
