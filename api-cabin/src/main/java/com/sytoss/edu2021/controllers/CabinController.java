package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.models.Cabin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CabinController {
    @GetMapping("/cabin")
    @ResponseBody
    public String writeEngine() {
        return "I am cabin";
    }
}
