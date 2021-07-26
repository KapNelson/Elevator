package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.CabinDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinRepository extends CrudRepository<CabinDTO, Integer> {
    CabinDTO findCabinDTOById (Integer idCabin);

    CabinDTO findCabinDTOByBuildingIdAndNumber(int buildingId,int cabinNumber);
}