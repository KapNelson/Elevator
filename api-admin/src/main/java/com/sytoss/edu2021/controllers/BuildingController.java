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
        return buildingService.registerBuilding(buildingBOM);
    }

    @PostMapping("/{buildingId}/engine")
    public EngineBOM registerEngine(@PathVariable Integer buildingId,@RequestBody CabinBOM cabin) {
        return engineService.addEngineToBuilding(buildingId,cabin);
    }

    @GetMapping("/find/engine/{buildingId}/{number}")
    public EngineBOM getEngineByIdBuildingAndNumber(@PathVariable Integer buildingId, @PathVariable Integer number){
        return engineService.getEngineByIdBuildingAndNumber(buildingId,number);
    }


}