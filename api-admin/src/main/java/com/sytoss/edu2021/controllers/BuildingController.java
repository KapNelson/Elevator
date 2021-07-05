package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.models.Building;
import com.sytoss.edu2021.models.Cabin;
import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private CabinRepository cabinRepository;

    // TODO: register a building
    @PostMapping
    public Building registerBuilding(@RequestBody Building building) {
        Building result = building;

        // TODO: validate building
        if (result.isValid()) {
            // TODO: check is object exists with the same address
            Building checkBuilding = buildingRepository.findBuildingByAddress(result.getAddress());
            if (checkBuilding != null)
                throw new IllegalArgumentException("Building with this address already registered. BuildingId=" + checkBuilding.getId());
            else {
                // TODO: insert into DB
                result = buildingRepository.save(result);
            }
        } else {
            return null;
        }

        // TODO: return object with filled id
        return result;
    }


    // TODO: register a cabin for building
    @PostMapping("/cabin/{id}")
    public Cabin registerCabin(@PathVariable Integer id, @RequestBody Cabin cabin){
        Building building = buildingRepository.findBuildingById(id);
        if(building!=null) {
            Cabin checkCabin = cabinRepository.findCabinByBuilding_IdAndAndNumber(id,cabin.getNumber());
            if(checkCabin!=null){
                throw new IllegalArgumentException("Cabin is already exists in this building");
            }
            else{
                Cabin result = new Cabin(cabin.getNumber(), building);
                building.addCabin(result);
                return cabinRepository.save(result);
            }
        }else {
            throw new IllegalArgumentException("There is no such building");
        }
    }

    // TODO: get full information about building by id
    @GetMapping("/findById")
    public Building searchBuildingById(@RequestParam Integer id) {
        Building building = buildingRepository.findBuildingById(id);
        if (building != null) {
            return building;
        } else {
            throw new IllegalArgumentException("There is no building with such id");
        }
    }


    // TODO: search building by address ???
    @GetMapping("/findByAddress")
    public Building searchBuildingByAddress(@RequestParam String address) {
        Building building = buildingRepository.findBuildingByAddress(address);
        if (building != null) {
            return building;
        } else {
            throw new IllegalArgumentException("There is no building on this address");
        }
    }

}

