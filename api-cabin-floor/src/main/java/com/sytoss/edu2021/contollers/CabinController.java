package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cabin_floor/cabin")
public class CabinController {


   @Autowired
   private CabinService cabinService;

    @GetMapping("/call/{buildingId}/{cabinNumber}/{floor}")
    public CabinBOM callToFloor(@PathVariable int buildingId, @PathVariable int cabinNumber, @PathVariable int floor) {
        return cabinService.goToFloor(buildingId,cabinNumber,floor);
    }

    @GetMapping("/send/message/{idCabin}")
    public String sendMessage(@PathVariable int idCabin){
        return cabinService.sendMessage(idCabin);
    }


}