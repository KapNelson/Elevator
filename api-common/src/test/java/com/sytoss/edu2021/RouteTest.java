//package com.sytoss.edu2021;
//
//import com.sytoss.edu2021.common.Direction;
//import com.sytoss.edu2021.common.Route;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RouteTest {
//
//    private final Route route = new Route();
//
//    @Test
//    public void hasQueueOfFloorsTest() {
//        route.getQueueOfFloors().clear();
//        List<Integer> testingQueue = new ArrayList<>();
//        testingQueue.add(1);
//        testingQueue.add(2);
//        testingQueue.add(3);
//
//        route.setQueueOfFloors(testingQueue);
//        for (int i = 0; i < testingQueue.size(); i++) {
//            assertEquals(testingQueue.get(i), route.getQueueOfFloors().get(i));
//            route.clearRoute();
//        }
//    }
//
//    @Test
//    public void cleanRouteTest() {
//        route.addRoutFloor(1, 10);
//        route.clearRoute();
//
//        assertEquals(0, route.getQueueOfFloors().size());
//    }
//
//    @Test
//    public void addStopToQueueTest() {
//        route.addRoutFloor(1, 10);
//
//        assertEquals(1, route.getQueueOfFloors().size());
//    }
//
//    @Test
//    public void checkQueueOrderTest() {
//        route.addRoutFloor(5, 10); // 10
//        route.addRoutFloor(10, 3);// 3
//        route.addRoutFloor(3, 7); //  7
//
//        for (int i = 0; i < route.getQueueOfFloors().size() - 1; i++) {
//            assertTrue(route.getQueueOfFloors().get(i) > route.getQueueOfFloors().get(i + 1));
//        }
//    }
//
//    @Test
//    public void checkUniqueTest() {
//        route.addRoutFloor(5, 10);  //  10
//        route.addRoutFloor(10, 3);  //  3
//        route.addRoutFloor(10, 3);  //  3
//
//        assertEquals(2, route.getQueueOfFloors().size());
//
//        for (int i = 0; i < route.getQueueOfFloors().size() - 1; i++) {
//            assertNotEquals(route.getQueueOfFloors().get(i), route.getQueueOfFloors().get(i + 1));
//        }
//    }
//
//    @Test
//    public void directionTestsUPTest() {
//        route.addRoutFloor(1, 10);
//        assertEquals(Direction.UP, route.getDirection());
//
//    }
//
//    @Test
//    public void directionTestsDOWNTest() {
//        route.addRoutFloor(10, 1);
//        assertEquals(route.getDirection(), Direction.DOWN);
//
//    }
//
//    @Test
//    public void directionTestsTheSameTest() {
//        route.addRoutFloor(1, 1);
//        assertEquals(route.getDirection(), Direction.STABLE);
//
//    }
//}