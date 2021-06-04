
package com.sytoss.edu2021.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@ToString()
public class Cabin {

    private Integer[] floorButtons;
    @Setter
    private boolean isDoorOpened;
    @Setter
    private boolean isOverloaded;
    private final Engine engine;
    private List<Integer> queueOfFloors;
    @Setter
    private int currentFloor;
    private Direction direction = Direction.STABLE;

    public void addFloorToStop(int floorNumber) {
        if (floorNumber > floorButtons[0] && floorNumber < floorButtons[floorButtons.length - 1] && queueOfFloors.contains(floorNumber)) {

            return;
        }

        direction = setDirection(currentFloor, floorNumber);
        queueOfFloors.add(floorNumber);
        Collections.sort(queueOfFloors, Collections.reverseOrder());


    }

    public Direction setDirection(int initFloor, int aimFloor) {

        if (initFloor < aimFloor)
            return Direction.UP;
        else if (initFloor > aimFloor)
            return Direction.DOWN;
        else {
            System.err.println("You have already reached this floor.");
            return Direction.STABLE;
        }

    }

    private void setFloors(int startFloor, int endFloor) {

        int floorsNumber = endFloor - startFloor + 1;
        floorButtons = new Integer[floorsNumber];

        int curfloor = startFloor;
        for (int i = 0; i < floorsNumber; i++) {
            floorButtons[i] = curfloor;
            ++curfloor;
        }

        this.currentFloor = startFloor;
    }

    public Cabin(int startFloor, int endFloor) {
        setFloors(startFloor, endFloor);
        engine = new Engine();
        queueOfFloors = new ArrayList<>();
    }

    public void openDoor() {
        if (!isDoorOpened)
            isDoorOpened = true;
    }

    public void closeDoor() {
        if (isDoorOpened) {
            isDoorOpened = false;
        }
    }

}