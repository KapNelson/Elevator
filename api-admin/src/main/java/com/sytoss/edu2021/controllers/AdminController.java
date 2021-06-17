package com.sytoss.edu2021.controllers;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class AdminController {
    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello, World";
    }

}

