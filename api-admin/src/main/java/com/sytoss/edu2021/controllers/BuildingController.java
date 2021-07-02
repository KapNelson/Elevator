package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.models.Building;
import com.sytoss.edu2021.models.BuildingBOM;
import com.sytoss.edu2021.repo.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingRepository buildingRepository;


    @PostMapping
    public Building registerBuilding(@RequestParam String address,@RequestParam Integer floorAmount) {
        Building building = new Building(address,floorAmount);

        // TODO: validate building
        if (building.isValid()) {
            // TODO: check is object exists with the same address
            Building checkBuilding = buildingRepository.findBuildingByAddress(building.getAddress());
            if (checkBuilding != null)
                return null;
            else {
                // TODO: insert into DB
                buildingRepository.save(building);
            }
        } else {
            return null;
        }

        // TODO: return object with filled id
        return building;
    }





    // TODO: register a building
    // TODO: register a cabin for building
    // TODO: get full information about building by id

    // TODO: search building by address ???

}

