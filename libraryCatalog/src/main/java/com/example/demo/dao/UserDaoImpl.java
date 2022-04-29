package com.example.demo.dao;

import com.example.demo.dao.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public User getByLoginPassword(String login, String password) {
        throw new UnsupportedOperationException();
    }
}
