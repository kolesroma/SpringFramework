package com.example.demo.dao;

import static org.mockito.Mockito.*;

import com.example.demo.dao.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserDaoMock {
    @Bean
    @Scope("singleton")
    public UserDao userDao() {
        UserDao userDao = mock(UserDao.class);
        when(userDao.getByLoginPassword("admin", "admin"))
                .thenReturn(new User("<script>alert('roma')</script>", User.Role.ADMIN));
        when(userDao.getByLoginPassword("client", "client"))
                .thenReturn(new User("alex", User.Role.CLIENT));
        return userDao;
    }
}
