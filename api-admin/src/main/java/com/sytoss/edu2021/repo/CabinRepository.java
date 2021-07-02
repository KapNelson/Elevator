package com.sytoss.edu2021.repo;


import com.sytoss.edu2021.models.Building;
import com.sytoss.edu2021.models.Cabin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface CabinRepository extends CrudRepository<Cabin, Integer> {
    Cabin findCabinById(Integer id);
}