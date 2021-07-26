package com.sytoss.edu2021.services;

import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.contollers.FeignProxyAdmin;
import com.sytoss.edu2021.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class FloorService {

    @Autowired
    private FeignProxyAdmin proxyAdmin;

    public RouteBOM addFloorToRoute(Integer buildingId, Integer cabinNumber, Integer floorNumber) {
        try {
            return proxyAdmin.addPoint(buildingId, cabinNumber, floorNumber);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
