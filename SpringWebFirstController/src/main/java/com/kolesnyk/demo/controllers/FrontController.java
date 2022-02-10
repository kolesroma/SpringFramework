package com.kolesnyk.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontController {

    @GetMapping("/helloString")
    @ResponseBody
    public String helloString() {
        return "hello world";
    }

}
