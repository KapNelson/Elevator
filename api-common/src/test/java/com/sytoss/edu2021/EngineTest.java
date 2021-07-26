//package com.sytoss.edu2021;
//
//import com.sytoss.edu2021.bom.EngineBOM;
//import com.sytoss.edu2021.common.Direction;
//import com.sytoss.edu2021.common.Floor;
//import com.sytoss.edu2021.common.Route;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class EngineTest {
//
//    private final Route route = new Route();
//    private final EngineBOM engine = new EngineBOM(route, new ArrayList<Floor>(15), 1);
//
//    @Test
//    public void engineMovementUpOnePoint() {
//        engine.setCurrentFloor(1);
//        route.addRoutFloor(1, 10);
//
//        while (engine.getCurrentFloor() != 10) {
//            engine.start();
//        }
//
//        assertEquals(0, route.getQueueOfFloors().size());
//        assertEquals(Direction.STABLE, route.getDirection());
//    }
//
//    @Test
//    public void engineMovementDownOnePoint() {
//        engine.setCurrentFloor(10);
//        route.addRoutFloor(10, 1);
//
//        while (engine.getCurrentFloor() != 1) {
//            engine.start();
//        }
//
//        assertEquals(0, route.getQueueOfFloors().size());
//        assertEquals(Direction.STABLE, route.getDirection());
//    }
//
//    @Test
//    public void engineMovementUpMultipleStops() {
//        engine.setCurrentFloor(1);
//        route.addRoutFloor(1, 3);   //  3
//        route.addRoutFloor(1, 5);   //  5
//        route.addRoutFloor(1, 7);   //  7
//        route.addRoutFloor(1, 10);  //  10
//
//        while (engine.getCurrentFloor() != 10) {
//            engine.start();
//        }
//
//        assertEquals(0, route.getQueueOfFloors().size());
//        assertEquals(Direction.STABLE, route.getDirection());
//    }
//
//    @Test
//    public void engineMovementDownMultipleStops() {
//        engine.setCurrentFloor(10);
//        route.addRoutFloor(10, 1);   //  3
//        route.addRoutFloor(10, 5);   //  5
//        route.addRoutFloor(10, 7);   //  7
//
//        while (engine.getCurrentFloor() != 1) {
//            engine.start();
//        }
//
//        assertEquals(0, route.getQueueOfFloors().size());
//        assertEquals(Direction.STABLE, route.getDirection());
//    }
//
//    @Test
//    public void engineMovementTheSameFloor() {
//        engine.setCurrentFloor(10);
//        route.addRoutFloor(10, 10);
//        engine.move();
//
//        assertEquals(0, route.getQueueOfFloors().size());
//        assertEquals(Direction.STABLE, route.getDirection());
//    }
//
//    @Test
//    public void emergencyStopWhileStopped() {
//        engine.setCurrentFloor(10);
//        route.addRoutFloor(10, 1);   //  3
//        route.addRoutFloor(10, 5);   //  5
//        route.addRoutFloor(10, 7);   //  7
//        engine.callEmergencyStop();
//        assertFalse(engine.isEmergencyStop());
//    }
//}
