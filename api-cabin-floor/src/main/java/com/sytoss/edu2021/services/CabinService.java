package com.sytoss.edu2021.services;

import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.CabinBOM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CabinService {

    @Autowired
    private RestTemplate restTemplate;

    // Call cabin from floor
    public void callToFloor(String buildingAddress, int cabinNumber, int floor) {
        Map<String, String> variablesForCabin = new HashMap<>();
        Map<String, String> a = new HashMap<>();
        a.put("address", buildingAddress);
        variablesForCabin.put("address", buildingAddress);
        variablesForCabin.put("number", String.valueOf(cabinNumber));
        System.out.println(1);
        BuildingBOM building = restTemplate.getForEntity("http://127.0.0.1:6060/api/building/find/address/{address}", BuildingBOM.class, a).getBody();
        System.out.println(2);
        CabinBOM cabin = restTemplate.getForEntity("http://127.0.0.1:6060/api/building/find/cabin/{address}/{number}", CabinBOM.class, variablesForCabin).getBody();
        if (building.getFloorsAmount() < floor || floor <= 0) {
            throw new ValidationException("Incorrect number of floor");
        } else {
            System.out.println(building);
        }


        // TODO: make validation (building/cabin/flor)
        // TODO: send command to engine


    }

    public void goToFloor(int buildingId, int cabinNumber, int endFlow) {
        Map<String, String> variables = new HashMap<>();
        variables.put("id", "1");
        ResponseEntity<BuildingBOM> building = restTemplate.getForEntity("http://127.0.0.1:6060/api/building/{id}", BuildingBOM.class, variables);
        // TODO: make validation(building/cabin/flor) + cabin checks (weight is door closed);
        // TODO: send command to engine


    }

}
