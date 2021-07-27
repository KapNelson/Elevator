package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.EngineDTO;
import com.sytoss.edu2021.repo.dto.RouteDTO;
import com.sytoss.edu2021.repo.dto.RouteDTOId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<RouteDTO, RouteDTOId> {

    RouteDTO findRouteDTOByRouteDTOId(RouteDTOId routeDTOId);

    RouteDTO[] findAllByRouteDTOId_IdEngine(int idEngine);
}
