package com.sytoss.edu2021.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Entity(name = "app_build")
@ToString
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_build")
    private int id;

    @Column
    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    @Column(name = "number_of_floors")
    private int floorsAmount;

    @OneToMany(mappedBy = "building")
    @Setter
    private List<Cabin> cabins;

    public Building(){

    }

    public Building(String address,int floorsAmount){
        this.address =address;
        this.floorsAmount = floorsAmount;
        this.cabins = new ArrayList<>(1);
    }

    public List<Cabin> getCabins() {
        return Collections.unmodifiableList(cabins);
    }

    public void addCabin(Cabin cabin) {
        cabins.add(cabin);
    }

    public boolean isValid() {
        return !ObjectUtils.isEmpty(address) && floorsAmount > 1;
    }

}
