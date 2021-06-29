package com.sytoss.edu2021.contollers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class FloorController {
    @GetMapping("/floor")
    public RedirectView showFloor(@RequestParam(name = "floor", required = true) Integer numFloor) {

        /*for (int i = 0; i < test.length; i++)
            test[i] = i + 1;
        if (numFloor == null) {
            model.addAttribute("panel", "1");
        } else {
            model.addAttribute("panel", numFloor);
        }
        model.addAttribute("listFloor", test.toString());*/

        RedirectView view = new RedirectView("/elevatorCall/");
        view.addStaticAttribute("curFloor",numFloor);
        return view;

    }

    @GetMapping("/elevatorCall")
    public RedirectView callElevator(Model model, @RequestParam(name = "curFloor", required = true) Integer floor) {

        RedirectView view = new RedirectView("/");
        view.addStaticAttribute("curFloor",floor);
        return view;

    }
}

    
//    @GetMapping("/")
//    public String hello(Model model, @RequestParam(name = "floor", required = false) String numFloor) {
//        int[] test = new int[9];
//        for (int i = 0; i < test.length; i++)
//            test[i] = i + 1;
//        if (numFloor == null) {
//            model.addAttribute("panel", "1");
//        } else {
//            model.addAttribute("panel", numFloor);
//        }
//        model.addAttribute("listFloor", test);
//        return "floor";
//    }


