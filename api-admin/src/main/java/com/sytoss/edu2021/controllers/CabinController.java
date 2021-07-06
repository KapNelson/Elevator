package com.sytoss.edu2021.controllers;


import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.repo.dto.CabinDTO;
import com.sytoss.edu2021.services.BuildingService;
import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class CabinController {

    @Autowired
    private CabinService cabinService;

    // TODO: register a cabin for building
    @PostMapping("{id}/cabin")
    public CabinBOM registerCabin(@PathVariable Integer id, @RequestBody CabinBOM cabin) {
       return cabinService.register(id,cabin);
    }
}
