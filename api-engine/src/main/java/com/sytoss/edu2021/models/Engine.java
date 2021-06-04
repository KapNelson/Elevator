
package com.sytoss.edu2021.models;


public class Engine {
    private Cabin cabin;

    public void moveUp(int distance) {

    }

    public void moveDown(int distance) {

    }

    //TODO: private??
    public void start() {
        cabin.closeDoor();
        cabin.setMovingState(true);
        // Realization elevator moving
        //

    }

    public void stop() {
        // Realization elevator stop
        cabin.setMovingState(false);
        cabin.openDoor();
    }
}