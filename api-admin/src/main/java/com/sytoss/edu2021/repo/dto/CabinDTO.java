package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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


    public CabinDTO(int number) {
        this.number = number;
    }

    public CabinDTO() {

    }

}