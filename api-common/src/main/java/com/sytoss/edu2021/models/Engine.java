
package com.sytoss.edu2021.models;

import lombok.Getter;

@Getter
public class Engine {

    private boolean isMoving;
    private final Route route;
    private boolean isEmergencyStop;

    public Engine(Route route) {
        this.route = route;
    }

    public void move(int currentFloor) {

        if (route.getDirection() == Direction.UP) {

            start();
            int maxFloor = route.getQueueOfFloors().get(0);

            for (; currentFloor <= maxFloor; currentFloor++) {

                if (isEmergencyStop) {
                    emergencyStop(currentFloor);
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

                if (isEmergencyStop) {
                    emergencyStop(currentFloor);
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

    private void emergencyStop(int currentFloor) {

        route.clearRoute();
        stop();
        route.setDirection(Direction.STABLE);

    }

    public void callEmergencyStop() {
        if (isMoving) {
            isEmergencyStop = true;
        }
    }
}