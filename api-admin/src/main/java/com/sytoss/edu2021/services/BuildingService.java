package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.exceptions.AlreadyExistsException;
import com.sytoss.edu2021.exceptions.EntityNotFoundException;
import com.sytoss.edu2021.exceptions.ValidationException;
import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.CabinRepository;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.services.convertor.BuildingConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BuildingService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private BuildingRepository buildingRepository;

    public BuildingBOM registerBuilding(BuildingBOM building) {
        if (building.isValid()) {
            try {
                BuildingBOM checkBuilding = searchByAddress(building.getAddress());
                throw new AlreadyExistsException("Building with this address already registered. BuildingId=" + checkBuilding.getId());
            } catch (EntityNotFoundException e) {
                BuildingDTO dto = new BuildingDTO();
                new BuildingConvertor().toDTO(building, dto);
                dto = buildingRepository.save(dto);
                new BuildingConvertor().fromDTO(dto, building);
                return building;
            }
        } else {
            throw new ValidationException("Data is not valid");
        }
    }


    private BuildingBOM searchByAddress(String address) {
        BuildingDTO building = buildingRepository.findBuildingByAddress(address);
        if (building != null) {
            BuildingBOM buildingBOM = new BuildingBOM();
            new BuildingConvertor().fromDTO(building, buildingBOM);
            return buildingBOM;
        } else {
            throw new EntityNotFoundException("There is no building on this address: " + address);
        }
    }

    public BuildingBOM findBuildingById(Integer buildingId) {
        BuildingDTO dto = buildingRepository.findBuildingById(buildingId);
        if (dto == null) {
            throw new EntityNotFoundException(buildingId, "There is no such building " + buildingId);
        }
        BuildingBOM result = new BuildingBOM();
        new BuildingConvertor().fromDTO(dto, result);
        return result;
    }
}