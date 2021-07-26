package com.sytoss.edu2021.repo.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "app_build")
public class BuildingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_build")
    @Getter
    @Setter
    private int id;

    @Column
    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    @Column(name = "number_of_floors")
    private int floorsAmount;

    @OneToMany(mappedBy = "building", fetch = FetchType.EAGER)
    @Setter
    @Getter
    private List<EngineDTO> engines = new ArrayList<>();

    public BuildingDTO() {

    }

    public BuildingDTO(String address, int floorsAmount) {
        this.address = address;
        this.floorsAmount = floorsAmount;
        this.engines = new ArrayList<>();
    }

    public List<EngineDTO> getEngine() {
        return engines;
    }

    public void addEngine(EngineDTO engine) {
        engines.add(engine);
    }

    public boolean isValid() {
        return !ObjectUtils.isEmpty(address) && floorsAmount > 1;
    }
}