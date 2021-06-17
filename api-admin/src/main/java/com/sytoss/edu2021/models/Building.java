package com.sytoss.edu2021.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;


@Entity
@ToString
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Getter
    @Setter
    private String address;
    @Column
    @Getter
    @Setter
    private int number;
    @Getter
    @Setter
    @Column(name = "floors_amount")
    private int floorsAmount;

    @OneToMany(mappedBy = "building")
    @Setter
    private List<Cabin> cabins;
    public List<Cabin> getCabins()
    {
        return Collections.unmodifiableList(cabins);
    }
    public void addCabin(Cabin cabin)
    {
        cabins.add(cabin);
    }

}
