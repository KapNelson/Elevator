package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.contollers.FeignProxyAdmin;
import com.sytoss.edu2021.contollers.FeignProxyEngine;
import com.sytoss.edu2021.exceptions.EntityNotFoundException;
import org.quartz.xml.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class CabinService {

    @Autowired
    private FeignProxyEngine proxyEngine;
    @Autowired
    private FeignProxyAdmin proxyAdmin;

    public RouteBOM addFloorToRoute(int buildingId, int cabinNumber, int floorNumber) {
        BuildingBOM buildingBOM = proxyAdmin.findBuildingById(buildingId);
        if(floorNumber>buildingBOM.getFloorsAmount() || floorNumber <= 0)
            throw new IllegalArgumentException("You can`t get to this floor. There is no such floor");
        try {
            return proxyEngine.addFloorToRoute(buildingId, cabinNumber, floorNumber);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    public void startMovement(Integer buildingId, Integer cabinNumber) {
        proxyEngine.startMovement(buildingId, cabinNumber);
    }
}

