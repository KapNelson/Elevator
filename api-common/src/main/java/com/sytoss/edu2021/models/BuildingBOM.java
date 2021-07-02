package com.sytoss.edu2021.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Getter
@Setter
public class BuildingBOM {

    private Integer id;
    private String address;
    private Integer floorCount;

    private ArrayList<Cabin> cabins;

    public BuildingBOM(Integer id,String address,Integer floorCount){
        setId(id);
        setAddress(address);
        setFloorCount(floorCount);
    }

    public boolean isValid() {
        return !ObjectUtils.isEmpty(address) && floorCount > 1;
    }
}
