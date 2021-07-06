package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class BuildingBOM {

    private Integer id;
    private String address;
    private Integer floorsAmount;

    private ArrayList<CabinBOM> cabins;

    public BuildingBOM() {
    }

    public BuildingBOM(String address, int floorsAmount){
        this.address =address;
        this.floorsAmount = floorsAmount;
        this.cabins = new ArrayList<>(1);
    }

    public List<CabinBOM> getCabins() {
        return Collections.unmodifiableList(cabins);
    }

    public void addCabin(CabinBOM cabin) {
        cabins.add(cabin);
    }

    public boolean isValid() {
        return !ObjectUtils.isEmpty(address) && floorsAmount > 1;
    }

}
