package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping
    public BuildingBOM registerBuilding(@RequestBody BuildingBOM buildingBOM) {
        return buildingService.register(buildingBOM);
    }

    @PostMapping("{buildingId}/cabin")
    public BuildingBOM registerCabin(@PathVariable Integer buildingId, @RequestBody CabinBOM cabin) {
        return buildingService.addCabin(buildingId, cabin);
    }

    @GetMapping("/find/address/{address}")
    public BuildingBOM searchBuildingByAddress(@PathVariable String address) {
        return buildingService.searchByAddress(address);
    }
}