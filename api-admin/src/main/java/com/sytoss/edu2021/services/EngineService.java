package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.common.EngineStatus;
import com.sytoss.edu2021.exceptions.AlreadyExistsException;
import com.sytoss.edu2021.exceptions.EntityNotFoundException;
import com.sytoss.edu2021.exceptions.ValidationException;
import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.CabinRepository;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinDTO;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.services.convertor.BuildingConvertor;
import com.sytoss.edu2021.services.convertor.CabinConvertor;
import com.sytoss.edu2021.services.convertor.EngineConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineService {
    @Autowired
    private EngineRepository engineRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private CabinRepository cabinRepository;


    public EngineBOM addEngineToBuilding(Integer buildingId, CabinBOM cabin) {
        BuildingBOM building = findBuildingById(buildingId);
        EngineDTO controllEngine = engineRepository.findEngineDTOByBuildingIdAndCabinNumber(buildingId, cabin.getNumber());
        if (controllEngine != null) {
            throw new AlreadyExistsException("Building id= " + buildingId + " already contains cabin with number = " + cabin.getNumber());
        }
        if (cabin.isValid()) {
            saveCabin(cabin);
            EngineBOM engine = new EngineBOM();
            setEngineBOM(engine, building, cabin);
            saveEngine(engine, building, cabin);
            return engine;
        } else {
            throw new ValidationException("The cabin is invalid");
        }
    }

    private void saveEngine(EngineBOM engine, BuildingBOM building, CabinBOM cabin) {
        EngineDTO engineDTO = new EngineDTO();
        new EngineConvertor().toDTO(engine, engineDTO);
        new EngineConvertor().toDTO(cabin, engineDTO);
        new EngineConvertor().toDTO(building, engineDTO);
        engineDTO = engineRepository.save(engineDTO);
        new EngineConvertor().fromDTO(engineDTO, engine);
    }

    private void setEngineBOM(EngineBOM engine, BuildingBOM building, CabinBOM cabin) {
        engine.setId(cabin.getId());
        engine.setBuilding(building);
        engine.setCabin(cabin);
        engine.setCurrentFloor(1);
        engine.setStatus(EngineStatus.STOP);
    }

    private void saveCabin(CabinBOM cabin) {
        CabinDTO cabinDTO = new CabinDTO();
        new CabinConvertor().toDTO(cabin, cabinDTO);
        cabinDTO = cabinRepository.save(cabinDTO);
        new CabinConvertor().fromDTO(cabinDTO, cabin);
    }

    private BuildingBOM findBuildingById(Integer buildingId) {
        BuildingDTO buildingDTO = buildingRepository.findBuildingById(buildingId);
        if (buildingDTO == null) {
            throw new EntityNotFoundException("There is no building with id= " + buildingId + ".\nYou can not add a cabin.");
        }
        BuildingBOM buildingBOM = new BuildingBOM();
        new BuildingConvertor().fromDTO(buildingDTO, buildingBOM);
        return buildingBOM;
    }

    public EngineBOM getEngineByIdBuildingAndNumber(int idBuilding, int numberOfCabin) {
        BuildingDTO buildingDTO = buildingRepository.findBuildingById(idBuilding);
        EngineDTO engineDTO = engineRepository.findEngineDTOByBuildingIdAndCabinNumber(buildingDTO.getId(), numberOfCabin);
        if (engineDTO == null) {
            throw new EntityNotFoundException("There is no such cabin");
        }
        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO, engineBOM);

        BuildingBOM buildingBOM = new BuildingBOM();
        new BuildingConvertor().fromDTO(buildingDTO, buildingBOM);

        return engineBOM;
    }
}
