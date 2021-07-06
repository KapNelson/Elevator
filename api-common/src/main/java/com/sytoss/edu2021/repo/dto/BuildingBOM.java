package com.sytoss.edu2021.repo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private ArrayList<CabinBOM> cabins = new ArrayList<>();

    public BuildingBOM() {
    }

    public BuildingBOM(String address, int floorsAmount){
        this.address =address;
        this.floorsAmount = floorsAmount;
    }
    @JsonIgnore
    public List<CabinBOM> getCabins() {
        return Collections.unmodifiableList(cabins);
    }

    public List<String> getCabinsInfo() {
        List<String> cabinNumbers = new ArrayList<>();

        if(cabins!=null) {
            for (CabinBOM cabin : cabins) {
                String tmp = "number: " + cabin.getNumber();
                cabinNumbers.add(tmp);
            }
        }
        return Collections.unmodifiableList(cabinNumbers);

    }

    public void addCabin(CabinBOM cabin) {
        cabins.add(cabin);
    }

    public boolean isValid() {
        return !ObjectUtils.isEmpty(address) && floorsAmount > 1;
    }

}
