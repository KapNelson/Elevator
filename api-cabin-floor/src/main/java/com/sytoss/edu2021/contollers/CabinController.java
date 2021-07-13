package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cabin_floor/cabin")
public class CabinController {


   @Autowired
   private CabinService cabinService;

    @GetMapping("/call/{buildingAddress}/{cabinNumber}/{floor}")
    public CabinBOM callToFloor(@PathVariable String buildingAddress, @PathVariable int cabinNumber, @PathVariable int floor) {
        return cabinService.callToFloor(buildingAddress,cabinNumber,floor);
    }

    @GetMapping("/gotofloor/{buildingAddress}/{cabinNumber}/{fromFloor}/{toFloor}")
    public CabinBOM goToFloor(@PathVariable String buildingAddress, @PathVariable int cabinNumber, @PathVariable int fromFloor, @PathVariable int toFloor) {
        return cabinService.goToFloor(buildingAddress,cabinNumber,fromFloor,toFloor);
    }



}