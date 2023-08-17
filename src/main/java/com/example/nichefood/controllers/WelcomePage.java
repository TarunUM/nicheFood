package com.example.nichefood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomePage {
    @RequestMapping(value = "/")
    public String index() {
        return "welcome";
    }
}
