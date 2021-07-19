package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity(name = "app_cabin")
@ToString
public class CabinDTO {
    @Id
    @Column(name = "id_cabin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int number;
    @ManyToOne
    @JoinColumn(name = "id_build")
    @Getter
    @Setter
    private BuildingDTO building;

    public CabinDTO(int number, BuildingDTO building) {
        this.number = number;
        this.building = building;
    }

    public CabinDTO() {

    }

}