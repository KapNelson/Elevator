package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.bom.CabinBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="api-admin", url="localhost:6060/api/cabin")
public interface FeignProxyCabin {
    @GetMapping("/get/{buildingId}/{cabinNumber}")
    CabinBOM getCabin(@PathVariable int buildingId, @PathVariable int cabinNumber);
}
