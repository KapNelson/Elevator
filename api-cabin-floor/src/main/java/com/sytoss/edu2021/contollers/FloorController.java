package com.sytoss.edu2021.contollers;
import com.sytoss.edu2021.bom.CabinBOM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cabin_floor/floor")
public class FloorController {
    @Autowired
    private FloorService floorService;

    @GetMapping("/gotofloor/{buildingId}/{cabinNumber}/{toFloor}")
    public CabinBOM goToFloor(@PathVariable int buildingId, @PathVariable int cabinNumber, @PathVariable int toFloor) {
        return floorService.goToFloor(buildingId,cabinNumber,toFloor);
    }
}

