package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;


public class Floor {
    private CabinBOM cabin;
    @Getter
    @Setter
    private int numberOfFloor;
    @Getter
    @Setter
    private boolean buttonUp;
    @Getter
    @Setter
    private boolean buttonDown;
    @Getter
    @Setter
    private boolean hasCabinOnFloor;

    public Floor(int numberOfFloor, CabinBOM pCabin) {
        buttonDown = false;
        buttonDown = false;
        this.cabin=pCabin;
        this.numberOfFloor = numberOfFloor;
        checkCabinOnFloor();
    }

    public void checkCabinOnFloor(){
        if(numberOfFloor == cabin.getEngine().getCurrentFloor())
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