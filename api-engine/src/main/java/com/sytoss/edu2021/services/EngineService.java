package com.sytoss.edu2021.services;

import com.sytoss.edu2021.ApiEngineApplication;
import com.sytoss.edu2021.strategy.WaitingStrategy;
import com.sytoss.edu2021.strategy.future.EngineFutureTask;
import com.sytoss.edu2021.strategy.quartz.ElevatorJob;
import com.sytoss.edu2021.bom.EngineBOM;
import com.sytoss.edu2021.common.EngineStatus;
import com.sytoss.edu2021.repo.EngineRepository;
import com.sytoss.edu2021.repo.RouteRepository;
import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.services.convertor.EngineConvertor;
import com.sytoss.edu2021.strategy.quartz.JobQuartz;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EngineService {

    @Autowired
    EngineRepository engineRepository;
    @Autowired
    RouteRepository routeRepository;

    private WaitingStrategy strategy;


    public EngineBOM addEngine(Integer buildingId, Integer cabinId) {
        EngineDTO engineDTO = new EngineDTO();
        engineDTO.setId(cabinId);
        engineDTO.setBuildingId(buildingId);
        engineDTO.setCabinId(cabinId);
        engineDTO.setCurrentFloor(1);
        engineDTO.setEngineStatus(EngineStatus.STOP);
        engineDTO = engineRepository.save(engineDTO);
        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO, engineBOM);
        return engineBOM;
    }

    public void startMovement(Integer buildingId, Integer cabinNumber, String strategyType, long waitTime) {
        EngineDTO engineDTO = engineRepository.findEngineDTOByBuildingIdAndCabinId(buildingId, cabinNumber);
        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO, engineBOM);

        JobDataMap data = new JobDataMap();
        data.put("routeRepository", routeRepository);
        data.put("engineRepository", engineRepository);
        data.put("engine", engineBOM);

        if (strategyType.equals("JobQuartz"))
            strategy = new JobQuartz(waitTime);
        else if (strategyType.equals("FutureTask"))
            strategy = new EngineFutureTask(waitTime);
        else
            throw new RuntimeException("Unsupported type");
        strategy.startJob(data);

    }

    public void startMovement(String strategyType, long waitTime) {
        List<EngineDTO> engines = engineRepository.findAll();
        List<EngineBOM> engineBOMs = new ArrayList<>();

        for (EngineDTO engineDTO : engines) {
            EngineBOM engineBOM = new EngineBOM();
            new EngineConvertor().fromDTO(engineDTO, engineBOM);

            engineBOMs.add(engineBOM);
        }

        JobDataMap data = new JobDataMap();
        data.put("routeRepository", routeRepository);
        data.put("engineRepository", engineRepository);
        data.put("engines", engineBOMs);

        if (strategyType.equals("JobQuartz"))
            strategy = new JobQuartz(waitTime);
        else if (strategyType.equals("FutureTask"))
            strategy = new EngineFutureTask(waitTime);
        else
            throw new RuntimeException("Unsupported type");
        strategy.startJob(data);

    }

    public EngineBOM getEngine(Integer engineId) {
        EngineDTO engineDTO = engineRepository.findEngineDTOById(engineId);
        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO, engineBOM);
        return engineBOM;
    }


}
