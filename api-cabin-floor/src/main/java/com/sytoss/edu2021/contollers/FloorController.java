package com.sytoss.edu2021.contollers;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cabin_floor/floor")
public class FloorController {
    @Autowired
    private FloorService floorService;

    @PostMapping("/add/point/{buildingId}/{cabinNumber}/{floorNumber}")
    public RouteBOM addPoint(@PathVariable Integer buildingId, @PathVariable Integer cabinNumber, @PathVariable Integer floorNumber){
        return floorService.addFloorToRoute(buildingId,cabinNumber,floorNumber);
    }
}

