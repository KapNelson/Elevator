package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.services.BuildingService;
import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private CabinService cabinService;

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

    @GetMapping("/find/id/{id}")
    public BuildingBOM searchBuildingById(@PathVariable Integer id) {
        return buildingService.searchById(id);
    }


    @GetMapping("/find/cabin/address/{address}/{number}")
    public CabinBOM getCabin(@PathVariable String address, @PathVariable Integer number){
        return cabinService.getCabin(address,number);
    }

    @GetMapping("/find/cabin/id/{buildingId}/{number}")
    public CabinBOM getCabinByIdBuilding(@PathVariable Integer buildingId, @PathVariable Integer number){
        return cabinService.getCabinByIdBuilding(buildingId,number);
    }

    @GetMapping("/get/cabin/id/{idCabin}")
    public CabinBOM getCabinById(@PathVariable Integer idCabin){
        return cabinService.getCabinById(idCabin);
    }

    @GetMapping("/get/information/about/cabin/{idCabin}")
    public String getMessageAboutEmergencyInCabin(@PathVariable Integer idCabin){
        return cabinService.getMessageAboutEmergencyInCabin(idCabin);
    }
}