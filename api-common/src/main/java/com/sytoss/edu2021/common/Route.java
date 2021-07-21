package com.sytoss.edu2021.common;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class
Route {

    private Set<Integer> queueOfFloors;
    private Direction direction = Direction.STABLE;

    public Route() {
        queueOfFloors = new TreeSet<>();
    }

    public void addRoutFloor(int currentFloor, int floorNumber) {
        if (queueOfFloors.contains(floorNumber)) {
            return;
        }
        if(direction.equals(Direction.UP) && floorNumber < this.getMinValue()) {
            return;
        }
        if(direction.equals(Direction.DOWN) && floorNumber > this.getMaxValue()) {
            return;
        }

        setDirection(currentFloor, floorNumber);
        if (currentFloor != floorNumber)
            queueOfFloors.add(floorNumber);
        //queueOfFloors.sort(Collections.reverseOrder());
    }

    public void clearRoute() {
        direction = Direction.STABLE;
        queueOfFloors.clear();
    }

    public void setDirection(int initFloor, int aimFloor) {

        if (initFloor < aimFloor)
            direction = Direction.UP;
        else if (initFloor > aimFloor)
            direction = Direction.DOWN;
        else {
            direction = Direction.STABLE;
        }
    }

    public int getMaxValue() {
        return Collections.max(queueOfFloors);
    }

    public int getMinValue() {
        return Collections.min(queueOfFloors);
    }
}
