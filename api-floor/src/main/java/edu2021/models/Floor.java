package edu2021.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Floor {
    private int numberOfFloor;
    @Getter
    @Setter
    private boolean buttonUp;
    @Getter
    @Setter
    private boolean buttonDown;

    public Floor(int numberOfFloor) {
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
