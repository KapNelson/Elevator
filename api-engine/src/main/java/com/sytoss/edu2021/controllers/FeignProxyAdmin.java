package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="api-admin", url="localhost:6060/api")
public interface FeignProxyAdmin {
    @GetMapping("/cabin/get/{buildingId}/{cabinNumber}")
    CabinBOM getCabin(@PathVariable int buildingId, @PathVariable int cabinNumber);

    @GetMapping("/cabin/get/{cabinId}")
    CabinBOM getCabin(@PathVariable int cabinId);

    @GetMapping("/building/find/{buildingId}")
    BuildingBOM findBuildingById(@PathVariable Integer buildingId);
}
