package com.sytoss.edu2021.services;

import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.services.convertor.BuildingConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public BuildingBOM register(BuildingBOM building){
        if (building.isValid()) {
            BuildingDTO checkBuilding = buildingRepository.findBuildingByAddress(building.getAddress());

            if (checkBuilding != null) {
                throw new AlreadyExistsException("Building with this address already registered. BuildingId=" + checkBuilding.getId());
            } else {
                BuildingDTO dto = new BuildingDTO();
                new BuildingConvertor().toDTO(building, dto);

                dto = buildingRepository.save(dto);

                new BuildingConvertor().fromDTO(dto, building);

                return building;
            }
        } else {
            throw new ValidationException("data is not valid");
        }
    }
}
