package com.sytoss.edu2021.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity(name = "app_cabin")
@ToString
public class Cabin {
    @Id
    @Column(name = "id_cabin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Getter
    @Setter
    private int number;

    @ManyToOne
    @JoinColumn(name = "id_build")
    @Getter
    private Building building;

    public Cabin(int number,Building building){
        this.number = number;
        this.building =building;
    }

    public Cabin() {

    }
}
