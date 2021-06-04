package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.models.Cabin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

@Controller
public class CabinController {

    private final Cabin cabin = new Cabin(-3, 12);

    @GetMapping("/")
    public String writeEngine(Model model, @RequestParam(name = "newFloor",required = false) Integer floor) {

        Arrays.sort(cabin.getFloorButtons(), Collections.reverseOrder());
        model.addAttribute("title", "Cabin Interface");
        model.addAttribute("buttonsList", cabin.getFloorButtons());


        if(floor != null){

            System.out.println("Floor from form:  = " + floor);
            System.out.println("Floor from getDirection:  = " + cabin.getDirection());

            cabin.addFloorToStop(floor);
            model.addAttribute("dir", cabin.getDirection());
        }



        return "cabin";
    }

}