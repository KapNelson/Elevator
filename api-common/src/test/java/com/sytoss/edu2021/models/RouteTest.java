package com.sytoss.edu2021.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

    private final Route route = new Route();

    @Test
    public void cleanRoute() {
        route.addRoutFloor(1, 10);
        route.clearRoute();

        assertEquals(0, route.getQueueOfFloors().size());

    }

    @Test
    public void addStopToQueue() {
        route.addRoutFloor(1, 10);

        assertEquals(1, route.getQueueOfFloors().size());

    }

    @Test
    public void checkQueueOrder() {
        route.addRoutFloor(5, 10); // 10
        route.addRoutFloor(10, 3);// 3
        route.addRoutFloor(3, 7); //  7

        for (int i = 0; i < route.getQueueOfFloors().size() - 1; i++) {
            assertTrue(route.getQueueOfFloors().get(i) > route.getQueueOfFloors().get(i+1));
        }

    }

    @Test
    public void checkUnique() {
        route.addRoutFloor(5, 10);  //  10
        route.addRoutFloor(10, 3);  //  3
        route.addRoutFloor(10, 3);  //  3

       assertEquals(2, route.getQueueOfFloors().size());

        for (int i = 0; i < route.getQueueOfFloors().size() - 1; i++) {
            assertNotEquals(route.getQueueOfFloors().get(i), route.getQueueOfFloors().get(i + 1));
        }
    }

    @Test
    public void directionTestsUP() {

        route.addRoutFloor(1, 10);
        assertEquals(Direction.UP, route.getDirection());

    }

    @Test
    public void directionTestsDOWN() {

        route.addRoutFloor(10, 1);
        assertEquals(route.getDirection(), Direction.DOWN);

    }

    @Test
    public void directionTestsTheSame() {

        route.addRoutFloor(1, 1);
        assertEquals(route.getDirection(), Direction.STABLE);

    }


}