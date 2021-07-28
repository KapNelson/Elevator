package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.common.RouteBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="api-engine", url="localhost:6050/api/engine")
public interface FeignProxyEngine {
    @PostMapping("/start/{buildingId}/{cabinNumber}")
    void startMovement(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber);

    @PostMapping("/add/route/{buildingId}/{cabinNumber}/{floorNumber}")
    RouteBOM addFloorToRoute(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber, @PathVariable Integer floorNumber);

    @GetMapping("/get/{buildingId}/{cabinNumber}")
    EngineBOM getEngineByBuildingAndCabin(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber);
    @GetMapping("/get/route/{buildingId}/{cabinNumber}")
    int getRoute(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber);
}
