package com.sytoss.edu2021.repo.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

    private final Route route = new Route(5);

    @Test
    public void hasQueueOfFloorsTest(){
        route.clearRoute();

        route.getQueueOfFloors()[2] = true;

        for(int i = 0; i < route.getQueueOfFloors().length; i++){
            if(i == 2)
                assertEquals(true, route.getQueueOfFloors()[i]);
            else
                assertEquals(false, route.getQueueOfFloors()[i]);
        }
    }

    @Test
    public void hasDirectionUPTest(){
        route.setDirection(Direction.UP);
        assertEquals(Direction.UP, route.getDirection());
    }

    @Test
    public void cleanRouteTest() {

    }

    @Test
    public void addStopToQueueTest() {

    }

    @Test
    public void checkUniqueTest() {

    }

    @Test
    public void directionTestsUPTest() {

    }

    @Test
    public void directionTestsDOWNTest() {

    }

    @Test
    public void directionTestsTheSameTest() {

    }
}
