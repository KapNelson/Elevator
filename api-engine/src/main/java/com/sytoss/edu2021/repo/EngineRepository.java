package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.EngineDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineRepository extends MongoRepository<EngineDTO, Integer> {
    EngineDTO findEngineDTOById(int id);

    EngineDTO findEngineDTOByBuildingIdAndCabinId(int buildingId, int cabinId);

    List<EngineDTO> findAll();
}
