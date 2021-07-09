package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "app_engine")
public class EngineDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "id_building")
    private Integer idBuilding;

    @Column(name = "id_cabin")
    private Integer idCabin;

}
