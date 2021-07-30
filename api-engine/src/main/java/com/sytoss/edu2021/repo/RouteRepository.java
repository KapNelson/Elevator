package com.sytoss.edu2021.repo;

import com.sytoss.edu2021.repo.dto.RouteDTO;
import com.sytoss.edu2021.repo.dto.RouteDTOId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends MongoRepository<RouteDTO, RouteDTOId> {
    RouteDTO findRouteDTOByRouteDTOId(RouteDTOId routeDTOId);

    RouteDTO[] findAllByRouteDTOId_IdEngine(int idEngine);

    void deleteByRouteDTOId(RouteDTOId routeDTOId);
}
