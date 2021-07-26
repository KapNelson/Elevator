package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.exceptions.AlreadyExistsException;
import com.sytoss.edu2021.exceptions.EntityNotFoundException;
import com.sytoss.edu2021.exceptions.ValidationException;
import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.services.convertor.BuildingConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    RestTemplate restTemplate;

    public BuildingBOM registerBuilding(BuildingBOM building) {
        if (building.isValid()) {
            try {
                BuildingBOM checkBuilding = findBuildingByAddress(building.getAddress());
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

    public BuildingBOM findBuildingByAddress(String address) {
        BuildingDTO building = buildingRepository.findBuildingByAddress(address);
        if (building != null) {
            BuildingBOM buildingBOM = new BuildingBOM();
            new BuildingConvertor().fromDTO(building, buildingBOM);
            return buildingBOM;
        } else {
            throw new EntityNotFoundException("There is no building on this address: " + address);
        }
    }


}