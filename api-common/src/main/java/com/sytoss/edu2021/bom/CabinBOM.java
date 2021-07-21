package com.sytoss.edu2021.bom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sytoss.edu2021.common.Route;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class CabinBOM {
    @Setter
    private int id;
    @Setter
    private int number;

/*    @JsonIgnore
    @Getter
    @Setter
    private BuildingBOM building;*/


    @Setter
    private Integer[] floorButtons;

    @Setter
    private boolean isDoorOpened;

    @Setter
    private boolean isOverloaded;


/*    @Getter
    @Setter
    @JsonIgnore
    private EngineBOM engine = null;*/

    @JsonIgnore
    @Setter
    private Route route = null;

    public CabinBOM() {
    }

    public CabinBOM(int number) {
        this.number = number;
    }

    public CabinBOM(int startFloor, int endFloor) {
        route = new Route();
        //engine = new EngineBOM(route, new ArrayList<Floor>(Math.abs(startFloor) + Math.abs(endFloor)),startFloor);
        setFloors(startFloor, endFloor);
    }

/*    public void startMovement() {
        engine.start();
    }*/

    private void setFloors(int startFloor, int endFloor) {
        int floorsNumber = endFloor - startFloor + 1;
        floorButtons = new Integer[floorsNumber];

        int curfloor = startFloor;
        for (int i = 0; i < floorsNumber; i++) {
            floorButtons[i] = curfloor;
            ++curfloor;
        }
    }

    /*public String getBuildingInfo() {
        String result = "address: " + building.getAddress();
        return result;
    }*/

    /*public BuildingBOM getBuilding(){
        return building;
    }*/

   /* public void addFloorToStop(int floorNumber) {
        if (floorNumber < floorButtons[0] && floorNumber > floorButtons[floorButtons.length - 1]) {
            return;
        }
        route.addRoutFloor(engine.getCurrentFloor(), floorNumber);
    }*/

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
        if (isOverloaded) {
            stringBuilder.append(" Overloaded!");
        }

        return stringBuilder.toString();
    }

    /*public void callEmergencyStop() {
        engine.callEmergencyStop();
    }*/

    public boolean isValid() {
        return number > 0;
    }
}