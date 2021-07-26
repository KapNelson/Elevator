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
    private int id;


    @Column(name = "current_floor")
    private int currentFloor;

    /* @Getter
     @Setter
     @ManyToOne
     @JoinColumn(name = "id_build")*/
    @Column(name = "id_build")
    private int buildingId;

    /* @Getter
     @Setter
     @OneToOne
     @JoinColumn(name = "id_cabin",referencedColumnName = "id_cabin")*/
    @Column(name = "id_cabin")
    private int cabinId;


    @Column(name = "status")
    private EngineStatus engineStatus;
}
