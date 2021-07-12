package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.CabinDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface CabinRepository extends CrudRepository<CabinDTO, Integer> {
    CabinDTO findCabinByBuilding_IdAndAndNumber(Integer idBuilding, Integer numberOfBuilding);
}