package com.sytoss.edu2021.services;

import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.dto.EngineBOM;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.services.convertor.EngineConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EngineService {

    @Autowired
    EngineRepository repository;

    public EngineBOM create(Integer idCabin) {

        EngineBOM engineBOM = new EngineBOM(idCabin);
        EngineDTO engineDTO = new EngineDTO();

        new EngineConvertor().toDTO(engineBOM, engineDTO);
        engineDTO = repository.save(engineDTO);
        new EngineConvertor().fromDTO(engineDTO, engineBOM);
        return engineBOM;
    }

    public EngineBOM[] getEngines(Integer[] ids) {
        EngineDTO[] engineDTOS = new EngineDTO[ids.length];
        EngineBOM[] engineBOMS = new EngineBOM[engineDTOS.length];
        EngineConvertor engineConvertor = new EngineConvertor();
        for (int i = 0; i < ids.length; i++) {
            engineDTOS[i] = repository.findEngineDTOById(ids[i]);
            engineBOMS[i] = new EngineBOM();
            engineConvertor.fromDTO(engineDTOS[i], engineBOMS[i]);
        }

        return engineBOMS;
    }

    public EngineBOM getEngine(Integer idCabin) {
        EngineDTO engineDTO = repository.findEngineDTById(idCabin);

        if (engineDTO == null) {
            throw new EntityNotFoundException("There is no such engine.");
        }

        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO, engineBOM);
        return engineBOM;
    }
}
