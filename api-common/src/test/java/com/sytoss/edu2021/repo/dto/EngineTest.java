package com.sytoss.edu2021.repo.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    private final Route route = new Route();
    private final Engine engine = new Engine(route, new ArrayList<Floor>(15));


    @Test
    public void engineStateTest() {
        engine.start();
        assertTrue(engine.isMoving());
        engine.stop();
        assertFalse(engine.isMoving());
    }

    @Test
    public void engineMovementUpOnePoint() {
        route.addRoutFloor(1, 10);
        engine.move(1);
        assertEquals(0, route.getQueueOfFloors().size());
        assertEquals(Direction.STABLE, route.getDirection());

    }

    @Test
    public void engineMovementDownOnePoint() {
        route.addRoutFloor(10, 1);
        engine.move(10);
        assertEquals(0, route.getQueueOfFloors().size());
        assertEquals(Direction.STABLE, route.getDirection());

    }

    @Test
    public void engineMovementUpMultipleStops() {
        route.addRoutFloor(1, 3);   //  3
        route.addRoutFloor(1, 5);   //  5
        route.addRoutFloor(1, 7);   //  7
        route.addRoutFloor(1, 10);  //  10
        engine.move(1);

        assertEquals(0, route.getQueueOfFloors().size());
        assertEquals(Direction.STABLE, route.getDirection());
    }

    @Test
    public void engineMovementDownMultipleStops() {
        route.addRoutFloor(10, 1);   //  3
        route.addRoutFloor(10, 5);   //  5
        route.addRoutFloor(10, 7);   //  7
        engine.move(10);

        assertEquals(0, route.getQueueOfFloors().size());
        assertEquals(Direction.STABLE, route.getDirection());
    }

    @Test
    public void engineMovementTheSameFloor() {
        route.addRoutFloor(10, 10);
        engine.move(10);

        assertEquals(0, route.getQueueOfFloors().size());
        assertEquals(Direction.STABLE, route.getDirection());

    }

    @Test
    public void emergencyStopWhileStopped()
    {
        route.addRoutFloor(10, 1);   //  3
        route.addRoutFloor(10, 5);   //  5
        route.addRoutFloor(10, 7);   //  7
        engine.move(10);
        engine.callEmergencyStop();

        assertFalse(engine.isEmergencyStop());
    }
}

