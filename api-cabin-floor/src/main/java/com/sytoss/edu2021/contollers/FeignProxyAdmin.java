package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.repo.dto.CabinBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="api-admin", url="localhost:6060/api/building")
public interface FeignProxyAdmin {
    @GetMapping("/find/cabin/id/{buildingId}/{number}")
    CabinBOM getCabinByIdBuilding(@PathVariable Integer buildingId, @PathVariable Integer number);
}
