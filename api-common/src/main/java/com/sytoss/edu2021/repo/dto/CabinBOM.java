package com.sytoss.edu2021.repo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class CabinBOM {

    @Getter
    @Setter
    @JsonIgnore
    private int id;
    @Getter
    @Setter
    private int number;

    @JsonIgnore
    @Getter
    @Setter
    private BuildingBOM building;


    @Setter
    private Integer[] floorButtons;

    @Setter
    private boolean isDoorOpened;

    @Setter
    private boolean isOverloaded;


    @Getter
    @Setter
    //@JsonIgnore
    private EngineBOM engine = null;

    @JsonIgnore
    private Route route = null;

    public CabinBOM() {

    }

    public CabinBOM(int number, BuildingBOM building) {

    }

    public CabinBOM(int startFloor, int endFloor) {

    }

    public void startMovement() {

    }

    private void setFloors(int startFloor, int endFloor) {

    }


    public void addFloorToStop(int floorNumber) {

    }

    public void openDoor() {

    }

    public void closeDoor() {

    }

    public String displayCabinInfo() {
        return null;
    }

    public void callEmergencyStop() {

    }

    public boolean isValid() {
        return number > 0;
    }
}