package com.sytoss.edu2021.repo;


import com.sytoss.edu2021.models.Building;
import com.sytoss.edu2021.models.Cabin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CabinRepository extends CrudRepository<Cabin, Integer> {
    Cabin findCabinByBuilding_IdAndAndNumber(Integer id, Integer number);

}