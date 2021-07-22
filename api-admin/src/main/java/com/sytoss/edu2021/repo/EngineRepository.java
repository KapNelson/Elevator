package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.EngineDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<EngineDTO,Integer> {
}
