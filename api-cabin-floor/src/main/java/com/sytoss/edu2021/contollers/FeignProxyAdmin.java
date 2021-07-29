package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.bom.BuildingBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-admin", url = "localhost:6060/api/building")
public interface FeignProxyAdmin {
    @GetMapping("/find/{buildingId}")
    BuildingBOM findBuildingById(@PathVariable Integer buildingId);
}
