package com.kolesnyk.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {

    @RequestMapping("/roma")
    public String romaPage() throws Exception {
        return "roma.html";
    }

    @RequestMapping("/vadum")
    public String vadumPage() throws Exception {
        return "vadum.html";
    }

    @RequestMapping("/alex")
    public String alexPage() throws Exception {
        return "alex.html";
    }

    @RequestMapping("/team")
    public String teamPage() throws Exception {
        return "team.html";
    }

}
