package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.bom.EngineBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "api-engine", url = "localhost:6050/api/engine")
public interface FeignProxyEngine {

    @PostMapping("/add/{buildingId}/{cabinId}")
    EngineBOM registerEngine(@PathVariable Integer buildingId, @PathVariable Integer cabinId);
}
