package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "app_engine")
public class EngineDTO {

    @Getter
    @Setter
    @Id
    @Column(name = "id_engine")
    Integer id;
    @Getter
    @Setter
    @Column(name="current_floor")
    int currentFloor;
}
