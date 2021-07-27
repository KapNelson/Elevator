package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.services.EngineService;
import com.sytoss.edu2021.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/engine")
public class EngineController {

    @Autowired
    private EngineService engineService;
    @Autowired
    private RouteService routeService;
/*
    @GetMapping("/{idCabin}")
    public EngineBOM create(@PathVariable Integer idCabin){
        return engineService.create(idCabin);
    }

    @PostMapping ("/engines/")
    public EngineBOM[] getEngines(@RequestBody Integer[] ids){
        return engineService.getEngines(ids);
    }

    @GetMapping ("/get/{buildingId}/{cabinNo}")
    public EngineBOM getEngine(@PathVariable Integer idCabin){
        return engineService.getEngine(idCabin);
    }
  
    @PostMapping("/update")
    public void update(@RequestBody EngineBOM engine){
        engineService.update(engine);
    }

    @GetMapping("/start_move/{cabinId}")
    public EngineBOM goToFloor(@RequestBody Integer cabinId) {
        return engineService.goToFloor(cabinId);
    }*/


    @PostMapping("/add/{buildingId}/{cabinId}")
    private EngineBOM registerEngine(@PathVariable Integer buildingId, @PathVariable Integer cabinId){
        return engineService.addEngine(buildingId,cabinId);
    }

    @PostMapping("/add/route/{buildingId}/{cabinNumber}/{floorNumber}")
    public RouteBOM addFloorToRoute(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber, @PathVariable Integer floorNumber){
        return routeService.addFloorToRoute(buildingId,cabinNumber,floorNumber);
    }
}
