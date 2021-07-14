package com.sytoss.edu2021.services;

import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.CabinRepository;
import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.repo.dto.CabinDTO;
import com.sytoss.edu2021.services.convertor.BuildingConvertor;
import com.sytoss.edu2021.services.convertor.CabinConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private CabinRepository cabinRepository;

    public BuildingBOM getBuildingById(int id) {
        BuildingDTO dto = buildingRepository.findBuildingById(id);
        if (dto == null) {
            throw new EntityNotFoundException(id, "There is no such building " + id);
        }
        BuildingBOM result = new BuildingBOM();
        new BuildingConvertor().fromDTO(dto, result);
        return result;
    }

    public BuildingBOM register(BuildingBOM building) {
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

    public BuildingBOM addCabin(int buildingId, CabinBOM cabin) {
        if (cabin.isValid()) {
            BuildingBOM building = getBuildingById(buildingId);
            if (building.findCabinByNumber(cabin.getNumber()) != null) {
                throw new ValidationException("Building id = " + buildingId + " already contains cabin with number = " + cabin.getNumber());
            } else {
                CabinDTO cabinDTO = new CabinDTO();
                new CabinConvertor().toDTO(cabin, cabinDTO);
                new CabinConvertor().toDTO(building, cabinDTO);
                cabinRepository.save(cabinDTO);
                building.addCabin(cabin);
                return building;
            }
        } else {
            throw new ValidationException("Invalid cabin number (number should be >0)");
        }
    }


    public BuildingBOM searchByAddress(String address) {
        BuildingDTO building = buildingRepository.findBuildingByAddress(address);
        if (building != null) {
            BuildingBOM buildingBOM = new BuildingBOM();
            new BuildingConvertor().fromDTO(building, buildingBOM);
            return buildingBOM;
        } else {
            throw new EntityNotFoundException("There is no building on this address: " + address);
        }
    }

    public BuildingBOM searchById(Integer id) {
        BuildingDTO building = buildingRepository.findBuildingById(id);
        if (building != null) {
            BuildingBOM buildingBOM = new BuildingBOM();
            new BuildingConvertor().fromDTO(building, buildingBOM);
            return buildingBOM;
        } else {
            throw new EntityNotFoundException("There is no building on this id: " + id);
        }
    }
}
