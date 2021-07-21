package com.sytoss.edu2021.services;

import com.sytoss.edu2021.common.Route;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.contollers.FeignProxyAdmin;
import com.sytoss.edu2021.contollers.FeignProxyEngine;
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

    @Autowired
    private FeignProxyEngine proxyEngine;

    public Route addFloorToRoute(int buildingId, int cabinNumber, int floorNumber) {
        CabinBOM cabin;
        try {
            cabin = proxyAdmin.getCabinByIdBuilding(buildingId, cabinNumber);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such cabin");
        }

        EngineBOM engine;
        try {
            engine = proxyEngine.getEngine(cabin.getId());
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such engine");
        }

        Route route = cabin.getRoute();

        route.addRoutFloor(engine.getCurrentFloor(), floorNumber);

        return route;
    }

    public void startMovement(int buildingId, int cabinNumber) {
        CabinBOM cabin;
        try {
            cabin = proxyAdmin.getCabinByIdBuilding(buildingId, cabinNumber);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such cabin");
        }

        EngineBOM engine;
        try {
            engine = proxyEngine.getEngine(cabin.getId());
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such engine");
        }

        engine.setRoute(cabin.getRoute());
    }

    public CabinBOM getCabinInfo(int buildingId, int cabinNumber) {
        CabinBOM cabin;
        try {
            cabin = proxyAdmin.getCabinByIdBuilding(buildingId, cabinNumber);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such cabin");
        }

        EngineBOM engine;
        try {
            engine = proxyEngine.getEngine(cabin.getId());
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such engine");
        }

        return cabin;
    }

    public String sendMessage(int idCabin) {
        try {
            CabinBOM cabinBOM = restTemplate.getForEntity("http://127.0.0.1:6060/api/building/get/cabin/id/{idCabin}", CabinBOM.class, idCabin).getBody();
            return "Emergency in the cabin: " + idCabin;
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}

