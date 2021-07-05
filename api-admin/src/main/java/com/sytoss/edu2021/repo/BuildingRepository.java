package com.sytoss.edu2021.repo;


import com.sytoss.edu2021.models.Building;
import com.sytoss.edu2021.models.BuildingBOM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
    Building findBuildingByAddress(String address);
    Building findBuildingById(Integer idBuilding);
}