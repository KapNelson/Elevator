package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.controllers.FeignProxyCabin;
import com.sytoss.edu2021.exceptions.AlreadyExistsException;
import com.sytoss.edu2021.exceptions.EntityNotFoundException;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.repo.dto.RouteDTO;
import com.sytoss.edu2021.repo.dto.RouteDTOId;
import com.sytoss.edu2021.services.convertor.RouteConvertor;
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
        EngineDTO engineDTO = engineRepository.findEngineDTOByBuildingIdAndCabinId(buildingId, cabinBOM.getId());
        if (engineDTO == null)
            throw new EntityNotFoundException("There is no such engine with buildingId: " + buildingId + " and cabinNumber: " + cabinNumber);

        RouteDTOId routeDTOId = new RouteDTOId();
        routeDTOId.setFloorNumber(floorNumber);
        routeDTOId.setIdEngine(engineDTO.getId());
        RouteDTO checkRoute = routeRepository.findRouteDTOByRouteDTOId(routeDTOId);
        if (checkRoute != null) {
            throw new AlreadyExistsException("This point is already in route!");
        } else {
            RouteDTO routeDTO = new RouteDTO();
            routeDTO.setRouteDTOId(routeDTOId);
            routeRepository.save(routeDTO);
        }
        RouteDTO[] routeDTOS = routeRepository.findAllByRouteDTOId_IdEngine(routeDTOId.getIdEngine());
        RouteBOM route = new RouteBOM();
        new RouteConvertor().fromDTO(routeDTOS, route);
        return route;
    }
}
