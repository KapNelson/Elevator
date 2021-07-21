package com.sytoss.edu2021.common;

import com.sytoss.edu2021.bom.CabinBOM;
import lombok.Getter;
import lombok.Setter;


public class Floor {
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
        this.numberOfFloor = numberOfFloor;
    }

    public void callToUp() {
        buttonUp = true;
    }

    public void callToDown() {
        buttonDown = true;
    }
}