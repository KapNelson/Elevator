package com.sytoss.edu2021.contollers;

//import com.sytoss.edu2021.models.Cabin;
import com.sytoss.edu2021.repo.dto.CabinBOM;
        import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import java.util.Arrays;
import java.util.Collections;

@Controller
public class CabinController {

    private final CabinBOM cabin = new CabinBOM(-3, 12);

    @GetMapping("/cabin")
    @ResponseBody
    public String writeEngine() {
        return "I am cabin";
    }

    @GetMapping("/")
    public String cabinInterfaceLogic(Model model, @RequestParam(name = "curFloor", required = true, defaultValue = "-13") Integer floor) {

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