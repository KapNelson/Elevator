package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.RouteDTO;
import com.sytoss.edu2021.repo.dto.RouteDTOId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<RouteDTO, RouteDTOId> {
    RouteDTO findRouteDTOByRouteDTOId(RouteDTOId routeDTOId);
    RouteDTO[] findAllByRouteDTOId_IdEngine(Integer id_engine);
}
