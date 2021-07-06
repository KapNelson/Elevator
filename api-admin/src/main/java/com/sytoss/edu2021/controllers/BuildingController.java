package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.CabinRepository;
import com.sytoss.edu2021.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private CabinRepository cabinRepository;

    // TODO: register a building
    @PostMapping
    public BuildingBOM registerBuilding(@RequestBody BuildingBOM buildingBOM) {
        return buildingService.register(buildingBOM);
    }


   /* // TODO: get full information about building by id
    @GetMapping("/findById")
    public BuildingDTO searchBuildingById(@RequestParam Integer id) {
*//*
        // TODO: check is object exists with the same id
        BuildingDTO building = buildingRepository.findBuildingById(id);
        if (building != null) {
            return building;
        } else {
            throw new IllegalArgumentException("There is no building with such id: " + id);
        }
*//*

    }


    // TODO: search building by address ???
    @GetMapping("/findByAddress")
    public BuildingDTO searchBuildingByAddress(@RequestParam String address) {
   *//*     // TODO: check is object exists with the same address
        BuildingDTO building = buildingRepository.findBuildingByAddress(address);
        if (building != null) {
            return building;
        } else {
            throw new IllegalArgumentException("There is no building on this address: " + address);
        }*//*
    }
*/
}

