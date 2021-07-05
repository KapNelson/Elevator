package com.sytoss.edu2021.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class BuildingBOM {

    private Integer id;
    private String address;
    private Integer floorsAmount;

    private ArrayList<Cabin> cabins;

    public BuildingBOM(String address,int floorsAmount){
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
