package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
public class Route {

    private final boolean[] queueOfFloors;
    private Direction direction = Direction.STABLE;

    public Route(int numOfFloors) {
        queueOfFloors = new boolean[numOfFloors];
        Arrays.fill(queueOfFloors, false);
    }

    public void addRoutFloor(int floorIndex) {
        queueOfFloors[floorIndex] = true;
    }

    public void clearRoute() {
        direction = Direction.STABLE;
        Arrays.fill(queueOfFloors, false);
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
}
