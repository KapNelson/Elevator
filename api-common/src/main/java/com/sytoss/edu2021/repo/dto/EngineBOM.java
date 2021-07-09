
package com.sytoss.edu2021.repo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class EngineBOM {

    private boolean isMoving;
    private final Route route;
    private final ArrayList<Floor> listOfFloors;
    private boolean isEmergencyStop;

    public EngineBOM(Route route, ArrayList<Floor> listOfFloors) {
        this.route = route;
        this.listOfFloors = listOfFloors;
    }

    public void move(int currentFloor) {

        if (route.getDirection() == Direction.UP) {
            start();
            int maxFloor = route.getQueueOfFloors().get(0);

            for (; currentFloor <= maxFloor; currentFloor++) {
                if (listOfFloors.size() != 0) {
                    for (int i = 0; i <= listOfFloors.size(); ++i) {
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
                    for (int i = 0; i <= listOfFloors.size(); ++i) {
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