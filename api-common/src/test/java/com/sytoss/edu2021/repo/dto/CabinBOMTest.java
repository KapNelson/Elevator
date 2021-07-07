package com.sytoss.edu2021.repo.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CabinBOMTest {

    private final CabinBOM cab = new CabinBOM(-3, 12);

    @Test
    public void checkIDTest(){
        cab.setId(1);
        assertEquals(1, cab.getId());
    }

    @Test
    public void checkNumberTest(){
        cab.setNumber(157);
        assertEquals(157, cab.getNumber());
    }

    @Test
    public void checkBuildingTest(){
        BuildingBOM building = new BuildingBOM();
        cab.setBuilding(building);
        assertEquals(building, cab.getBuilding());
    }

    @Test
    public void checkCurrentFloorTest(){
        cab.setCurrentFloor(10);
        assertEquals(10, cab.getCurrentFloor());
    }

    @Test
    public void checkDefaultCurrentFloorTest(){
        CabinBOM testCab = new CabinBOM();
        testCab.setCurrentFloor(1);
        assertEquals(1, testCab.getCurrentFloor());
    }

    @Test
    public void cabinButtonsSizeTest() {
        assertEquals(cab.getFloorButtons().length, 16);
    }

    @Test
    public void movementTest(){
        cab.startMovement();
        assertFalse(cab.getEngine().isMoving());
    }

    @Test
    public void addFloorToStopTest()
    {
        cab.getRoute().clearRoute();
        cab.addFloorToStop(6);
        cab.addFloorToStop(9);

        assertEquals(2, cab.getRoute().getQueueOfFloors().size());
    }

    @Test
    public void clearRouteTest(){
        cab.addFloorToStop(6);
        cab.addFloorToStop(7);
        cab.getRoute().clearRoute();

        assertEquals(0, cab.getRoute().getQueueOfFloors().size());
    }

    @Test
    public void openDoorTest(){
        cab.setDoorOpened(false);
        cab.openDoor();
        assertTrue(cab.isDoorOpened());
    }

    @Test
    public void closeDoorTest(){
        cab.closeDoor();
        assertFalse(cab.isDoorOpened());
    }

    @Test
    public void displayCabinInfoTest(){
        cab.getRoute().setDirection(Direction.DOWN);
        cab.setOverloaded(false);
        String msg = "DOWN " + cab.getCurrentFloor();
        assertEquals(msg, cab.displayCabinInfo());
    }

    @Test
    public void callEmergencyStopTest() {
        cab.callEmergencyStop();
        assertFalse(cab.getEngine().isEmergencyStop());
    }

    @Test
    public void validNumberTest1(){
        cab.setNumber(0);
        assertFalse(cab.isValid());
    }

    @Test
    public void validNumberTest2(){
        cab.setNumber(24);
        assertTrue(cab.isValid());
    }

}