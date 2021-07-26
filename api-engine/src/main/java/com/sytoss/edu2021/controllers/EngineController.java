package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.bom.EngineBOM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/engine")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @GetMapping("/{idCabin}")
    public EngineBOM createEngine(@PathVariable Integer idCabin){
        return engineService.create(idCabin);
    }

    @PostMapping ("/engines/")
    public EngineBOM[] getEngines(@RequestBody Integer[] ids){
        return engineService.getEngines(ids);
    }

    @GetMapping ("/get/{buildingId}/{cabinNo}")
    public EngineBOM getEngineById(@PathVariable Integer idCabin){
        return engineService.getEngine(idCabin);
    }
  
    @PostMapping("/update")
    public void updateCurrentFloor(@RequestBody EngineBOM engine){
        engineService.update(engine);
    }

    @GetMapping("/start_move/{cabinId}")
    public EngineBOM goToFloor(@RequestBody Integer cabinId) {
        return engineService.goToFloor(cabinId);
    }
}
