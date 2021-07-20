package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.repo.dto.EngineBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "api-cabin-floor", url = "localhost:6070/api/cabin_floor/floor")
public interface FeignProxyCabin {
    @GetMapping("/gotofloor/{buildingId}/{cabinNumber}/{toFloor}")
    public CabinBOM goToFloor(@PathVariable int buildingId, @PathVariable int cabinNumber, @PathVariable int toFloor);

}