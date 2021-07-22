package com.sytoss.edu2021.repo.dto;

import com.sytoss.edu2021.common.EngineStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity(name = "app_engine")
public class EngineDTO {


    @Id
    @Getter
    @Setter
    @Column(name = "id_engine")
    private Integer id;

    @Getter
    @Setter
    @Column(name="current_floor")
    private int currentFloor;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_build")
    private BuildingDTO building;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "id_cabin")
    private CabinDTO cabin;

    @Getter
    @Setter
    @Column(name="status")
    private EngineStatus engineStatus;
}
