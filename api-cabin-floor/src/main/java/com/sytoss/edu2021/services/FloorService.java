package com.sytoss.edu2021.services;

import com.sytoss.edu2021.contollers.FeignProxyAdmin;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class FloorService {
    @Autowired
    private FeignProxyAdmin proxyAdmin;



    public CabinBOM goToFloor(int buildingId, int cabinNumber, int endFloor) {
        /*CabinBOM cabin;
        try {
            cabin = proxyAdmin.getCabinByIdBuilding(buildingId, cabinNumber);
        } catch (HttpStatusCodeException e) {
            throw new EntityNotFoundException("There is no such cabin");
        }

        EngineBOM engine = proxyEngine.getEngine(cabin.getId());

        while (engine.getCurrentFloor() != endFloor) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            engine.start();
            proxyEngine.update(engine);
        }
        return cabin;*/
        return null;
    }
}
