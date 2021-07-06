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

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class CabinService {
    @Autowired
    private CabinRepository cabinRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    public CabinBOM register(Integer id, CabinBOM cabin) {

        BuildingDTO building = buildingRepository.findBuildingById(id);
        if (building != null) {
            // TODO: check is object exists with the same number
            CabinDTO checkCabin = cabinRepository.findCabinByBuilding_IdAndAndNumber(id, cabin.getNumber());
            if (checkCabin != null) {
                throw new AlreadyExistsException("Cabin is already exists in this building");
            } else {
                CabinDTO cabinDTO = new CabinDTO();
                cabinDTO.setBuilding(building);
                cabin.setBuilding(new BuildingBOM("",1));
                //new BuildingConvertor().fromDTO(cabinDTO.getBuildingObj(),cabin.getBuilding());

                new CabinConvertor().toDTO(cabin, cabinDTO);

                cabinDTO = cabinRepository.save(cabinDTO);
                building.addCabin(cabinDTO);

                new CabinConvertor().fromDTO(cabinDTO, cabin);
                // TODO: return object with filled id
                return cabin;
            }
        } else {
            throw new ValidationException("There is no such building " + id);
        }
    }
}
