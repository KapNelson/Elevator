package com.sytoss.edu2021.models;


import lombok.Getter;
import lombok.Setter;

@Getter
public class Cabin {

    private int[] floorButtons;
    @Setter
    private boolean isDoorOpened;
    @Setter
    private boolean isOverloaded;

    private void setFloors(int floorsNumber) {

        floorButtons = new int[floorsNumber];

        for (int i = 0; i < floorsNumber; i++) {
            floorButtons[i] = i + 1;
        }
    }

    public Cabin(int floorsNumber) {
        setFloors(floorsNumber);


    }

    public static void main(String[] args) {

        Cabin cab = new Cabin(5);

    }
}



