package com.sytoss.edu2021.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString()
public class Cabin {

    private int[] floorButtons;
    @Setter
    private boolean isDoorOpened;
    @Setter
    private boolean isOverloaded;
    private boolean isMoving;

    private final Engine engine;

    private List<Integer> queueOfFloors;


    public void addFloorToStop(int floorNumber) {
        if (floorNumber < floorButtons[0] || floorNumber > floorButtons[floorButtons.length - 1] || queueOfFloors.contains(floorNumber)) {
            return;
        } else {
            queueOfFloors.add(floorNumber);
        }
    }

    private void setFloors(int numberOfFloors) {

        floorButtons = new int[numberOfFloors];

        for (int i = 1; i < numberOfFloors + 1; ++i) {
            floorButtons[i] = i;
        }
    }

    public Cabin(int numberOfFloors) {
        setFloors(numberOfFloors);
        engine = new Engine();
    }

    public void setMovingState(boolean pState) {
        isMoving = pState;
    }

    public void openDoor() {
        if (!isDoorOpened || !isMoving)
            isDoorOpened = true;
    }

    public void closeDoor() {
        if (isDoorOpened) {
            isDoorOpened = false;
        }
    }

}
