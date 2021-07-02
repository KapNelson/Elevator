package com.sytoss.edu2021.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@ToString
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private int number;

    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;
}
