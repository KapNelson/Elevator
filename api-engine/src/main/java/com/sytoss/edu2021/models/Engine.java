
package com.sytoss.edu2021.models;


import lombok.Getter;

public class Engine {

    private boolean isMoving;
    private final Route route;

    public Engine(Route route) {
        this.route = route;
    }

    public void move(int currentFloor) {


        if (route.getDirection() == Direction.UP) {

            for (; currentFloor < route.getQueueOfFloors().get(route.getQueueOfFloors().size() - 1); currentFloor++) {
                start();

                if (route.getQueueOfFloors().contains(currentFloor)) {
                    route.getQueueOfFloors().remove(currentFloor);
                }
                stop();

            }
        } else if (route.getDirection() == Direction.DOWN) {

            for (; currentFloor > route.getQueueOfFloors().get(0); currentFloor--) {
                start();

                if (route.getQueueOfFloors().contains(currentFloor)) {
                    route.getQueueOfFloors().remove(currentFloor);
                }
                stop();

            }

        }


    }

    public void start() {
        isMoving = true;
    }

    public void stop() {
        isMoving = false;
    }
}