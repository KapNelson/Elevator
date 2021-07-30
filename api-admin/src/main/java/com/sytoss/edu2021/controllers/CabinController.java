package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cabin")
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @GetMapping("/get/{buildingId}/{cabinNumber}")
    public CabinBOM getCabin(@PathVariable int buildingId, @PathVariable int cabinNumber) {
        return cabinService.getCabin(buildingId, cabinNumber);
    }
}
