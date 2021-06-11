package com.sytoss.edu2021.models;

import lombok.Getter;
import lombok.Setter;


public class Floor {
    private Cabin cabin;
    @Getter
    private int numberOfFloor;
    @Getter
    @Setter
    private boolean buttonUp;
    @Getter
    @Setter
    private boolean buttonDown;
    @Getter
    private boolean hasCabinOnFloor;

    public Floor(int numberOfFloor, Cabin pCabin) {
        buttonDown = false;
        buttonDown = false;
        this.cabin=pCabin;
        this.numberOfFloor = numberOfFloor;
        checkCabinOnFloor();
    }

    public void checkCabinOnFloor(){
        if(numberOfFloor == cabin.getCurrentFloor())
            hasCabinOnFloor = true;
        else hasCabinOnFloor = false;
    }

    public String displayCabinInfo(){
        return cabin.displayCabinInfo();
    }

    public void callToUp() {
        buttonUp = true;
    }

    public void callToDown() {
        buttonDown = true;
    }
}