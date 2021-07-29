package com.sytoss.edu2021.services;

import com.sytoss.edu2021.ApiEngineApplication;
import com.sytoss.edu2021.bom.BuildingBOM;
import com.sytoss.edu2021.bom.CabinBOM;
import com.sytoss.edu2021.controllers.FeignProxyAdmin;
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
    private EngineRepository engineRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private FeignProxyAdmin proxyAdmin;

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

    public void startMovement(Integer buildingId, Integer cabinNumber, String strategyType) {
        CabinBOM cabinBOM = proxyAdmin.getCabin(buildingId,cabinNumber);
        BuildingBOM buildingBOM = proxyAdmin.findBuildingById(buildingId);
        EngineDTO engineDTO = engineRepository.findEngineDTOById(cabinBOM.getId());
        EngineBOM engineBOM = new EngineBOM();
        engineBOM.setCabin(cabinBOM);
        engineBOM.setBuilding(buildingBOM);
        new EngineConvertor().fromDTO(engineDTO, engineBOM);

        JobDataMap data = new JobDataMap();
        data.put("routeRepository", routeRepository);
        data.put("engineRepository", engineRepository);
        data.put("engine", engineBOM);

        if (strategyType.equals("JobQuartz"))
            strategy = new JobQuartz();
        else if (strategyType.equals("FutureTask"))
            strategy = new EngineFutureTask();
        else
            throw new RuntimeException("Unsupported type");
        strategy.startJob(data);
    }

    public void startMovement(String strategyType) {
        List<EngineDTO> engines = engineRepository.findAll();
        List<EngineBOM> engineBOMs = new ArrayList<>();
        CabinBOM cabinBOM;
        BuildingBOM buildingBOM;

        for (EngineDTO engineDTO : engines) {
            EngineBOM engineBOM = new EngineBOM();
            new EngineConvertor().fromDTO(engineDTO, engineBOM);

            engineBOMs.add(engineBOM);
        }

        for(int i=0;i<engines.size();++i){
            cabinBOM = proxyAdmin.getCabin(engines.get(i).getCabinId());
            engineBOMs.get(i).setCabin(cabinBOM);
            buildingBOM = proxyAdmin.findBuildingById(engines.get(i).getBuildingId());
            engineBOMs.get(i).setBuilding(buildingBOM);
        }

        JobDataMap data = new JobDataMap();
        data.put("routeRepository", routeRepository);
        data.put("engineRepository", engineRepository);
        data.put("engines", engineBOMs);

        if (strategyType.equals("JobQuartz"))
            strategy = new JobQuartz();
        else if (strategyType.equals("FutureTask"))
            strategy = new EngineFutureTask();
        else
            throw new RuntimeException("Unsupported type");
        strategy.startJob(data);

        try {
            if (!JobQuartz.scheduler.checkExists(new JobKey("myJob", "group1"))) {
                JobDetail job = JobBuilder.newJob(ElevatorJob.class)
                        .withIdentity("myJob", "group1")
                        .usingJobData(data)
                        .build();

                Trigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity("myTrigger", "group1")
                        .startNow()
                        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(5)
                                .repeatForever())
                        .build();

                JobQuartz.scheduler.scheduleJob(job, trigger);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public EngineBOM getEngine(Integer engineId) {
        EngineDTO engineDTO = engineRepository.findEngineDTOById(engineId);
        EngineBOM engineBOM = new EngineBOM();
        new EngineConvertor().fromDTO(engineDTO, engineBOM);
        return engineBOM;
    }


}
