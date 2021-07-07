package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.CabinRepository;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private BuildingRepository buildingRepository;

    // TODO: register a building
    @PostMapping
    public BuildingBOM registerBuilding(@RequestBody BuildingBOM buildingBOM) {
        return buildingService.register(buildingBOM);
    }

    // TODO: search building by address ???
    @GetMapping("/findByAddress")
    public BuildingBOM searchBuildingByAddress(@RequestParam String address) {
       return buildingService.searchByAddress(address);
    }

}

