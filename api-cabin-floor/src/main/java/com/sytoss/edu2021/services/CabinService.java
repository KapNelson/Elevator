package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.contollers.FeignProxyAdmin;
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
            return proxyAdmin.addPoint(buildingId,cabinNumber,floorNumber);
        }catch (HttpStatusCodeException e){
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    /*public void startMovement(int buildingId, int cabinNumber) {
    }

    public CabinBOM getCabinInfo(int buildingId, int cabinNumber) {
       return null;
    }

    public String sendMessage(int idCabin) {
        try {
            CabinBOM cabinBOM = restTemplate.getForEntity("http://127.0.0.1:6060/api/building/get/cabin/id/{idCabin}", CabinBOM.class, idCabin).getBody();
            return "Emergency in the cabin: " + idCabin;
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }*/
}

