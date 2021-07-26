package com.sytoss.edu2021.services;

import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.contollers.FeignProxyAdmin;
import com.sytoss.edu2021.contollers.FeignProxyEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class CabinService {

    @Autowired
    private FeignProxyAdmin proxyAdmin;

    @Autowired
    private FeignProxyEngine proxyEngine;

    public RouteBOM addFloorToRoute(int buildingId, int cabinNumber, int floorNumber) {
        try {
            return proxyAdmin.addPoint(buildingId, cabinNumber, floorNumber);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    public void startMovement(Integer buildingId, Integer cabinNumber) {
        proxyEngine.startMovement(buildingId, cabinNumber);
    }
}

