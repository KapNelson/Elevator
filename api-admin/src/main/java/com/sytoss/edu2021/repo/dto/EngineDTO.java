package com.sytoss.edu2021.repo.dto;

import com.sytoss.edu2021.common.EngineStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity(name = "app_engine")
public class EngineDTO {


    @Id
    @Column(name = "id_engine")
    private Integer id;

    @Column(name="current_floor")
    private int currentFloor;

    @ManyToOne
    @JoinColumn(name = "id_build")
    private BuildingDTO building;

    @OneToOne
    @JoinColumn(name = "id_cabin")
    private CabinDTO cabin;

    @Column(name="status")
    private EngineStatus engineStatus;
}
