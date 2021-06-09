package edu2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FloorController {
    @GetMapping("/")
    public String hello(Model model, @RequestParam(name = "floor", required = false) String numFloor) {
        int[] test = new int[9];
        for (int i = 0; i < test.length; i++)
            test[i] = i + 1;
        if (numFloor == null) {
            model.addAttribute("panel", "1");
        } else {
            model.addAttribute("panel", numFloor);
        }
        model.addAttribute("listFloor", test);
        return "floor";
    }
}
