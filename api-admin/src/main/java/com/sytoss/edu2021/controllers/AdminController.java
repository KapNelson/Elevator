package com.sytoss.edu2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello, World";
    }
}
