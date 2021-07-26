package com.sytoss.edu2021.contollers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="api-admin", url="localhost:6050/api/engine")
public interface FeignProxyEngine {
    @PostMapping("/start")
    void startMovement(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber);
}
