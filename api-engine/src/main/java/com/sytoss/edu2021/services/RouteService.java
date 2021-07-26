package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.controllers.FeignProxyCabin;
import com.sytoss.edu2021.exceptions.EntityNotFoundException;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.repo.dto.RouteDTO;
import com.sytoss.edu2021.repo.dto.RouteDTOId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private EngineRepository engineRepository;
    @Autowired
    private FeignProxyCabin feignProxyCabin;

    public RouteBOM addFloorToRoute(Integer buildingId, Integer cabinNumber, Integer floorNumber) {
        CabinBOM cabinBOM = feignProxyCabin.getCabin(buildingId, cabinNumber);
        EngineDTO engineDTO = engineRepository.findEngineDTOByBuildingIdAndCabinId(buildingId, cabinNumber);
        if (engineDTO == null)
            throw new EntityNotFoundException("There is no such engine with buildingId: " + buildingId + " and cabinNumber: " + cabinNumber);
        RouteDTO routeDTO = new RouteDTO();
        RouteDTOId routeDTOId = new RouteDTOId();
        routeDTOId.setIdEngine(engineDTO.getId());
        routeDTOId.setFloorNumber(floorNumber);
        routeDTO.setRouteDTOId(routeDTOId);
        routeRepository.save(routeDTO);
        return null;
    }
}
