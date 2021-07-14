package com.sytoss.edu2021.services;

import com.sytoss.edu2021.repo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CabinService {

    @Autowired
    private RestTemplate restTemplate;

    /*@Resource(name = "services.admin.url")
    private String adminBaseUrl;*/


    // Call cabin from floor
    public CabinBOM callToFloor(int buildingId, int cabinNumber, int floor) {
        Map<String, String> variablesForCabin = new HashMap<>();
        variablesForCabin.put("buildingId", String.valueOf(buildingId));
        variablesForCabin.put("number", String.valueOf(cabinNumber));
        CabinBOM cabin;
        EngineBOM engine;
        //BuildingBOM building = restTemplate.getForEntity("http://127.0.0.1:6060/api/building/find/address/{address}", BuildingBOM.class, buildingAddress).getBody();
        try {
            cabin = restTemplate.getForEntity("http://127.0.0.1:6060/api/building/find/cabin/id/{buildingId}/{number}", CabinBOM.class, variablesForCabin).getBody();
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException(e.getResponseBodyAsString());
            //throw new EntityNotFoundException("There is no such cabin");
        }
        if(cabin.getCurrentFloor() == floor) {
            cabin.openDoor();
        } else {
            cabin.setCurrentFloor(floor);
        }
        try {
            engine = setEngine(cabin);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such engine");
        }
        if (cabin.getFloorButtons().length < floor || floor < 0)
            throw new ValidationException("Incorrect number of floor");
        else {
            cabin.setEngine(engine);
        }


        return cabin;

    }

    public CabinBOM goToFloor(int buildingId, int cabinNumber, int currentFloor, int endFlow) {
        Map<String, String> variablesForCabin = new HashMap<>();
        variablesForCabin.put("buildingId", String.valueOf(buildingId));
        variablesForCabin.put("number", String.valueOf(cabinNumber));
        CabinBOM cabin;
        try {
            cabin = restTemplate.getForEntity("http://127.0.0.1:6060/api/building/find/cabin/id/{buildingId}/{number}", CabinBOM.class, variablesForCabin).getBody();
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such cabin");
        }
        cabin.setCurrentFloor(endFlow);
        EngineBOM engine = setEngine(cabin);
        cabin.setEngine(engine);
        Route route = new Route();
        route.addRoutFloor(cabin.getCurrentFloor(), endFlow);
        cabin.getEngine().setRoute(route);
        cabin.getEngine().move(endFlow);
        cabin.getEngine().getListOfFloors().get(currentFloor-1).setHasCabinOnFloor(false);
        cabin.getEngine().getListOfFloors().get(endFlow-1).setHasCabinOnFloor(true);
        return cabin;

    }

    public EngineBOM setEngine(CabinBOM cabin) {
        EngineBOM engine;
        try {
            engine = restTemplate.getForEntity("http://localhost:6050/api/engine", EngineBOM.class).getBody();
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such engine");
        }
        ArrayList<Floor> floors = new ArrayList<>();
        for (int i = 1; i <= cabin.getFloorButtons().length; ++i) {
            floors.add(new Floor(i, cabin));
        }
        engine.setListOfFloors(floors);
        for (int i = 1; i <= engine.getListOfFloors().size(); ++i) {
            if (engine.getListOfFloors().get(i - 1).getNumberOfFloor() == cabin.getCurrentFloor()) {
                engine.getListOfFloors().get(i - 1).setHasCabinOnFloor(true);
            }
        }
        return engine;
    }

}
