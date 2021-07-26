package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cabin")
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @GetMapping("/get/{buildingId}/{cabinNumber}")
    public CabinBOM getCabin(@PathVariable int buildingId, @PathVariable int cabinNumber) {
        return cabinService.getCabin(buildingId,cabinNumber);
    }
}
