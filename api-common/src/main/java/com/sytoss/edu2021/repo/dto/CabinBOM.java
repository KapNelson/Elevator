package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;

@Getter
@ToString
public class CabinBOM {

    @Getter
    private int id;
    @Getter
    @Setter
    private int number;
    @Getter
    @Setter
    private BuildingBOM building;

    private Integer[] floorButtons;
    @Setter
    private boolean isDoorOpened;
    @Setter
    private boolean isOverloaded;
    @Setter
    private Integer currentFloor;

    private final Engine engine;
    private final Route route;

    public CabinBOM(int startFloor, int endFloor) {
        setFloors(startFloor, endFloor);
        route = new Route();
        engine = new Engine(route, new ArrayList<Floor>(Math.abs(startFloor) + Math.abs(endFloor)));

    }

    public void startMovement() {
        engine.move(currentFloor);
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


    public void addFloorToStop(int floorNumber) {
        if (floorNumber > floorButtons[0] && floorNumber < floorButtons[floorButtons.length - 1]) {
            return;
        }
        route.addRoutFloor(currentFloor, floorNumber);

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

    public String displayCabinInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(route.getDirection());
        stringBuilder.append(" ");
        stringBuilder.append(currentFloor);
        if (isOverloaded) {
            stringBuilder.append(" Overloaded!!!");
        }

        return stringBuilder.toString();
    }

    public void callEmergencyStop() {
        engine.callEmergencyStop();
    }

}