package com.sytoss.edu2021.services;

import com.sytoss.edu2021.contollers.FeignProxyAdmin;
import com.sytoss.edu2021.contollers.FeignProxyEngine;
import com.sytoss.edu2021.repo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CabinService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignProxyAdmin proxyAdmin;

    @Autowired
    private FeignProxyEngine proxyEngine;

    public CabinBOM callToFloor(int buildingId, int cabinNumber, int floor) {
        CabinBOM cabin;
        EngineBOM engine;
        try {
            cabin = proxyAdmin.getCabinByIdBuilding(buildingId, cabinNumber);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException(e.getResponseBodyAsString());
        }
        if (cabin.getEngine().getCurrentFloor() == floor) {
            cabin.openDoor();
        } else {
            cabin.getEngine().setCurrentFloor(floor);
        }
        try {
            engine = proxyEngine.getEngine(cabin.getId());
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such engine");
        }
        if (cabin.getFloorButtons().length < floor || floor < 0)
            throw new ValidationException("Incorrect number of floor");
        else {
            ArrayList<Floor> floors = new ArrayList<>();
            for (int i = 1; i <= cabin.getFloorButtons().length; ++i) {
                floors.add(new Floor(i, cabin));
            }
            engine.setListOfFloors(floors);
            for (int i = 1; i <= engine.getListOfFloors().size(); ++i) {
                if (engine.getListOfFloors().get(i - 1).getNumberOfFloor() == cabin.getEngine().getCurrentFloor()) {
                    engine.getListOfFloors().get(i - 1).setHasCabinOnFloor(true);
                }
            }
            cabin.setEngine(engine);
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

