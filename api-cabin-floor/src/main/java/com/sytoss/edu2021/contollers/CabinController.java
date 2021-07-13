package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cabin_floor/cabin")
public class CabinController {


   @Autowired
   private CabinService cabinService;

    @GetMapping("/call/{buildingAddress}/{cabinNumber}/{floor}")
    public void callToFloor(@PathVariable String buildingAddress,@PathVariable int cabinNumber, @PathVariable int floor) {
        cabinService.callToFloor(buildingAddress,cabinNumber,floor);
    }



}