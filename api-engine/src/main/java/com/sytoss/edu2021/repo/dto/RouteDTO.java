package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;


@Getter
@Setter
@Entity(name = "app_route")
@Document(collection = "app_route")
public class RouteDTO {

    @EmbeddedId
    private RouteDTOId routeDTOId;

    public RouteDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteDTO routeDTO = (RouteDTO) o;
        return Objects.equals(routeDTOId, routeDTO.routeDTOId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeDTOId);
    }
}
