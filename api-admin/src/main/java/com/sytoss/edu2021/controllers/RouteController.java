package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

  /*  @PostMapping("/{buildingId}/{cabinNumber}/{floorNumber}")
    public RouteBOM addPoint(@PathVariable Integer buildingId,@PathVariable Integer cabinNumber,@PathVariable Integer floorNumber){
        return routeService.add(buildingId,cabinNumber,floorNumber);
    }*/
}
