package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.services.BuildingService;
import com.sytoss.edu2021.services.CabinService;
import com.sytoss.edu2021.services.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private CabinService cabinService;
    @Autowired
    private EngineService engineService;

    @PostMapping
    public BuildingBOM registerBuilding(@RequestBody BuildingBOM buildingBOM) {
        return buildingService.register(buildingBOM);
    }

    @PostMapping("/{buildingId}/engine")
    public EngineBOM registerEngine(@PathVariable Integer buildingId,@RequestBody CabinBOM cabin) {
        return engineService.addEngine(buildingId,cabin);
    }

    @PostMapping("/cabin")
    public CabinBOM registerCabin(@RequestBody CabinBOM cabin) {
        return cabinService.addCabin(cabin);
    }


    @GetMapping("/find/cabin/id/{buildingId}/{number}")
    public EngineBOM getCabinByIdBuilding(@PathVariable Integer buildingId, @PathVariable Integer number){
        return engineService.getEngineByIdBuildingAndNumber(buildingId,number);
    }
    /*

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

    @GetMapping("/get/cabin/id/{idCabin}")
    public CabinBOM getCabinById(@PathVariable Integer idCabin){
        return cabinService.getCabinById(idCabin);
    }

    @GetMapping("/get/information/about/cabin/{idCabin}")
    public String getMessageAboutEmergencyInCabin(@PathVariable Integer idCabin){
        return cabinService.getMessageAboutEmergencyInCabin(idCabin);
    }*/
}