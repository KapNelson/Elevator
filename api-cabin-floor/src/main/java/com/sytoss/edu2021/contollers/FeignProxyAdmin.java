package com.sytoss.edu2021.contollers;

import com.sytoss.edu2021.bom.RouteBOM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="api-admin", url="localhost:6060/api/route")
public interface FeignProxyAdmin {
    @PostMapping("/{buildingId}/{cabinNumber}/{floorNumber}")
    RouteBOM addFloorToRouteFromCabinInBuilding(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber, @PathVariable Integer floorNumber);
}
