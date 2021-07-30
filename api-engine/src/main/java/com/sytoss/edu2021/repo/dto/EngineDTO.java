package com.sytoss.edu2021.repo.dto;

import com.sytoss.edu2021.common.EngineStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "app_engine")
public class EngineDTO {

    @Id
    @Column(name = "id_engine")
    private int id;

    @Column(name = "current_floor")
    private int currentFloor;

    @Column(name = "id_build")
    private int buildingId;

    @Column(name = "id_cabin")
    private int cabinId;


    @Column(name = "status")
    private EngineStatus engineStatus;
}
