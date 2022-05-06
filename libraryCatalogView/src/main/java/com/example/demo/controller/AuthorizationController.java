package com.example.demo.controller;

import com.example.demo.dao.entity.User;
import com.example.demo.service.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AuthorizationController {
    private final Authorization authorization;
    private final HttpSession session;

    @Autowired
    public AuthorizationController(Authorization authorization, HttpSession session) {
        this.authorization = authorization;
        this.session = session;
    }

    @GetMapping("/")
    public String root() {
        return "login";
    }

    @PostMapping("login")
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        User user = authorization.login(login, password);
        if (user == null) return "noSuchUser";
        session.setAttribute("user", user);
        return "home";
    }
}
