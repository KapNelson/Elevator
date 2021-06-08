package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.models.Cabin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.Collections;


@Controller
public class CabinController {

    private final Cabin cabin = new Cabin(-3, 12);

    @GetMapping("/")
    public String cabinInterfaceLogic(Model model) {

        Arrays.sort(cabin.getFloorButtons(), Collections.reverseOrder());
        model.addAttribute("title", "Cabin Interface");
        model.addAttribute("buttonsList", cabin.getFloorButtons());
        model.addAttribute("dir", cabin.getRoute().getDirection());
        model.addAttribute("stopsList", cabin.getRoute().getQueueOfFloors());

        return "cabin";
    }


    @PostMapping("/addFloor")
    public String processForm(@RequestParam(name = "newFloor") Integer floor) {
        cabin.addFloorToStop(floor);
        return "redirect:/";
    }

}