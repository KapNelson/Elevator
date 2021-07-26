package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/cabin_floor/cabin")
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @PostMapping("/add/point/{buildingId}/{cabinNumber}/{floorNumber}")
    public RouteBOM addPoint(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber, @PathVariable Integer floorNumber){
        return cabinService.addFloorToRoute(buildingId,cabinNumber,floorNumber);
    }

    @PostMapping("/start/{buildingId}/{cabinNumber}")
    public void startMovement(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber){
        cabinService.startMovement(buildingId,cabinNumber);
    }

}

