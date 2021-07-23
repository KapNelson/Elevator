package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Getter
@Setter
@Entity(name = "app_route")
public class RouteDTO{

    @EmbeddedId
    private RouteDTOId routeDTOId;

    public RouteDTO() {
    }
}
