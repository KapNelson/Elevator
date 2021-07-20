package com.sytoss.edu2021.repo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class EngineBOM {

    private boolean isMoving;
    private Route route;
    private ArrayList<Floor> listOfFloors = new ArrayList<>();
    private boolean isEmergencyStop;
    private Integer id;

    private Integer currentFloor = 1;

    public EngineBOM() {
        listOfFloors = new ArrayList<>();
        route = new Route();
    }

    public EngineBOM(int id){
        this.id = id;
        listOfFloors = new ArrayList<>();
        route = new Route();

    }

    public EngineBOM(Route route, ArrayList<Floor> listOfFloors, Integer currentFloor) {
        this.route = route;
        this.listOfFloors = listOfFloors;
        this.currentFloor=currentFloor;

    }
    public void move() {
        if(route.getDirection().equals(Direction.UP)){
            if(currentFloor + 1 <= route.getMaxValue()) {
                currentFloor++;
                if(route.getQueueOfFloors().contains(currentFloor)) {
                    stop();
                    route.getQueueOfFloors().remove(currentFloor);
                }
            }
        }

        if(route.getDirection().equals(Direction.DOWN)){
            if(currentFloor-- >= route.getMinValue()) {
                currentFloor--;
                if(route.getQueueOfFloors().contains(currentFloor)) {
                    stop();
                    route.getQueueOfFloors().remove(currentFloor);
                }
            }
        }
    }

    public void start() {
        isMoving = true;
        isEmergencyStop = false;
        move();
    }

    public void stop() {
        isMoving = false;
        route.setDirection(Direction.STABLE);
    }

    private void emergencyStop() {
        route.clearRoute();
        stop();
        route.setDirection(Direction.STABLE);
    }

    public void callEmergencyStop() {
        if (isMoving) {
            emergencyStop();
            isEmergencyStop = true;
        }
    }
}