package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.RouteBOM;
import com.sytoss.edu2021.contollers.FeignProxyAdmin;
import com.sytoss.edu2021.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class CabinService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignProxyAdmin proxyAdmin;


    public RouteBOM addFloorToRoute(int buildingId, int cabinNumber, int floorNumber) {
        try {
            return proxyAdmin.addFloorToRouteFromCabinInBuilding(buildingId,cabinNumber,floorNumber);
        }catch (HttpStatusCodeException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

}

