package com.sytoss.edu2021.services;

import com.sytoss.edu2021.common.RouteBOM;
import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.repo.dto.RouteDTO;
import com.sytoss.edu2021.repo.dto.RouteDTOId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private BuildingRepository buildingRepository;

    public String add(Integer buildingId, Integer cabinNumber, Integer floorNumber) {

        BuildingDTO checkBuilding = buildingRepository.findBuildingById(buildingId);
        if (checkBuilding == null) {
            throw new EntityNotFoundException("There is no building with id= " + buildingId + ".");
        }

        EngineDTO engineDTO = engineRepository.findEngineDTOByBuildingIdAndCabinNumber(buildingId, cabinNumber);
        if (engineDTO == null) {
            throw new EntityNotFoundException("There is no cabin with number= " + cabinNumber +
                    " in building with id= " + buildingId + ".");
        }
        RouteDTOId routeDTOId = new RouteDTOId();
        routeDTOId.setFloorNumber(floorNumber);
        routeDTOId.setId_engine(engineDTO.getId());
        RouteDTO checkRoute = routeRepository.findRouteDTOByRouteDTOId(routeDTOId);
        if (checkRoute != null) {
            throw new AlreadyExistsException("This point is already in route");
        } else {
            RouteDTO routeDTO = new RouteDTO();
            routeDTO.setRouteDTOId(routeDTOId);
            routeRepository.save(routeDTO);
        }
        return "saved " + floorNumber;
    }


}
