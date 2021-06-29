package com.sytoss.edu2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EngineController {
    @GetMapping("/engine")
    @ResponseBody
    public String writeEngine() {
        return "I am engine";
    }
}
