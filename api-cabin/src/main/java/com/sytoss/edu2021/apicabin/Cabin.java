package com.sytoss.edu2021.apicabin;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class Cabin {

    private int[] floorButtons;
    private boolean isDoorOpened;
    private boolean isOverloaded;

    public void setFloors(int floorsNumber) {

        floorButtons = new int[floorsNumber];

        for (int i = 0; i < floorsNumber; i++) {
            floorButtons[i] = i + 1;
        }
    }


    public static void main(String[] args) {
        Cabin cab = new Cabin();


    }

}



