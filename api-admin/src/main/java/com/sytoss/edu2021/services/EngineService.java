package com.sytoss.edu2021.services;

import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.common.EngineStatus;
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


    public EngineBOM addEngine(Integer buildingId, CabinBOM cabin) {
        CabinDTO cabinDTO = new CabinDTO();
        new CabinConvertor().toDTO(cabin,cabinDTO);
        cabinDTO = cabinRepository.save(cabinDTO);
        new CabinConvertor().fromDTO(cabinDTO,cabin);
        EngineBOM engineBOM = new EngineBOM();
        engineBOM.setId(cabin.getId());
        BuildingDTO buildingDTO = buildingRepository.findBuildingById(buildingId);
        BuildingBOM buildingBOM = new BuildingBOM();
        new BuildingConvertor().fromDTO(buildingDTO, buildingBOM);
        engineBOM.setBuilding(buildingBOM);
        engineBOM.setCabin(cabin);
        engineBOM.setCurrentFloor(1);
        engineBOM.setStatus(EngineStatus.STOP);
        EngineDTO engineDTO = new EngineDTO();
        new EngineConvertor().toDTO(engineBOM, engineDTO);
        new EngineConvertor().toDTO(cabin, engineDTO);
        new EngineConvertor().toDTO(buildingBOM, engineDTO);
        engineDTO = engineRepository.save(engineDTO);
        new EngineConvertor().fromDTO(engineDTO, engineBOM);
        return engineBOM;
    }
}
