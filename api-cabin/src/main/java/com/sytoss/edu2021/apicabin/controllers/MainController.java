package com.sytoss.edu2021.apicabin.controllers;

import com.sytoss.edu2021.apicabin.models.Cabin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    @ResponseBody
    public String writeLine() {

        Cabin cabin = new Cabin(1,9);

        return cabin.toString();
    }

    @GetMapping("/login")
    @ResponseBody
    public String writeSmth(@RequestParam(name = "id", required = false) String str,@RequestParam(name = "number",required = false) int a)
    {
        return "залогиньтесь " + str + " " + a*a;
    }
}
