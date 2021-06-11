package com.sytoss.edu2021.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Cabin {

    private Integer[] floorButtons;
    @Setter
    private boolean isDoorOpened;
    @Setter
    private boolean isOverloaded;
    @Setter
    private Integer currentFloor;

    private final Engine engine;
    private final Route route;

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

    public Cabin(int startFloor, int endFloor) {
        setFloors(startFloor, endFloor);
        route = new Route();
        engine = new Engine(route);

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