package com.sytoss.edu2021.contollers;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.sytoss.edu2021.models.Cabin;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.Collections;

@Controller
public class CabinController {

    private final Cabin cabin = new Cabin(-3, 12);


    @GetMapping("/")
    public String cabinInterfaceLogic(Model model, @RequestParam(name = "curFloor", required = true,defaultValue="-13") Integer floor) {

        cabin.setCurrentFloor(floor);
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

        return "redirect:";
    }

}