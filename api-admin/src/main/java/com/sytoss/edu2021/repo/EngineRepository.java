package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.EngineDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends CrudRepository<EngineDTO,Integer> {
    /*@Query("SELECT e FROM app_engine e WHERE e.cabin.number IN(SELECT c.number FROM app_cabin c WHERE e.cabin.id = c.id AND c.number = ?2) " +
            "AND e.building = ?1")
    EngineDTO findEngineDTOByBuildingIdAndCabinNumber(Integer buildingId,Integer CabinNumber);*/

    EngineDTO findEngineDTOByBuildingIdAndCabinNumber(Integer buildingId,Integer CabinNumber);
}
