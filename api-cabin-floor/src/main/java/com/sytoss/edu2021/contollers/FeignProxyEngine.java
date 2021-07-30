package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.bom.RouteBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "api-engine", url = "localhost:6050/api/engine")
public interface FeignProxyEngine {
    @PostMapping("/start/{buildingId}/{cabinNumber}")
    void startMovement(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber);

    @PostMapping("/add/route/{buildingId}/{cabinNumber}/{floorNumber}")
    RouteBOM addFloorToRoute(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber, @PathVariable Integer floorNumber);
}
