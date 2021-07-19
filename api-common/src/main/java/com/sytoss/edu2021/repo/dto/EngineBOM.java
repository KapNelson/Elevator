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

        if (route.getDirection() == Direction.UP) {
            start();
            int maxFloor = route.getQueueOfFloors().get(0);

            for (; currentFloor <= maxFloor; currentFloor++) {
                if (listOfFloors.size() != 0) {
                    for (int i = 0; i < listOfFloors.size(); ++i) {
                        if (currentFloor == listOfFloors.get(i).getNumberOfFloor()) {
                            if (listOfFloors.get(i) != null) {
                                listOfFloors.get(i).setButtonUp(false);
                            }
                        }
                    }
                }
                if (isEmergencyStop) {
                    emergencyStop();
                }
                if (!isMoving) start();

                if (route.getQueueOfFloors().contains(currentFloor)) {
                    route.getQueueOfFloors().remove(route.getQueueOfFloors().indexOf(currentFloor));
                    stop();
                }
            }
        } else if (route.getDirection() == Direction.DOWN) {
            start();
            int minFloor = route.getQueueOfFloors().get(route.getQueueOfFloors().size() - 1);

            for (; currentFloor >= minFloor; currentFloor--) {

                if (listOfFloors.size() != 0) {
                    for (int i = 0; i < listOfFloors.size(); ++i) {
                        if (currentFloor == listOfFloors.get(i).getNumberOfFloor()) {
                            if (listOfFloors.get(i) != null) {
                                listOfFloors.get(i).setButtonDown(false);
                            }
                        }
                    }
                }

                if (isEmergencyStop) {
                    emergencyStop();
                }
                if (!isMoving) start();

                if (route.getQueueOfFloors().contains(currentFloor)) {
                    route.getQueueOfFloors().remove(route.getQueueOfFloors().indexOf(currentFloor));
                    stop();
                }
            }
        }
        route.setDirection(Direction.STABLE);

    }

    public void start() {
        isMoving = true;
        isEmergencyStop = false;
    }

    public void stop() {
        isMoving = false;
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