package com.sytoss.edu2021.repo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class EngineBOM {

    private boolean isMoving;
    private Route route;
    private ArrayList<Floor> listOfFloors = new ArrayList<>();
    private boolean isEmergencyStop;
    private Integer id;
    @Getter
    @Setter
    private Integer currentFloor=1;

    public EngineBOM(){

    }

    public EngineBOM(int id){

    }

    public EngineBOM(Route route, ArrayList<Floor> listOfFloors, Integer currentFloor) {

    }

    public void move() {

    }

    public void start() {

    }

    public void stop() {

    }

    private void emergencyStop() {

    }

    public void callEmergencyStop() {

    }
}