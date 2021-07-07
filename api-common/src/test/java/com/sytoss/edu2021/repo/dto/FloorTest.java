package com.sytoss.edu2021.repo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {
    private final CabinBOM cabin = new CabinBOM(-3,12);
    private final Floor floor = new Floor(5,cabin);

    @Test
    public void isFloorInTheMiddleOfBuilding(){
        floor.setButtonDown(true);
        floor.setButtonUp(true);
        assertTrue(floor.isButtonDown());
        assertTrue(floor.isButtonUp());
    }

    @Test
    public void checkNumberOfFloor(){
        assertEquals(5, floor.getNumberOfFloor());
    }

    @Test
    public void isCallToUp() {
        floor.callToUp();
        assertTrue(floor.isButtonUp());
    }

    @Test
    public void isCallToDown() {
        floor.callToDown();
        assertTrue(floor.isButtonDown());
    }
    @Test
    public void checkCabinIsOnFloor() {
        cabin.setCurrentFloor(5);
        floor.checkCabinOnFloor();
        assertTrue(floor.isHasCabinOnFloor());
    }
    @Test
    public void checkCabinIsNotOnFloor() {
        cabin.setCurrentFloor(1);
        floor.checkCabinOnFloor();
        assertFalse(floor.isHasCabinOnFloor());
    }
    @Test
    public void displayCabinInfoTest(){
        assertEquals(floor.displayCabinInfo(), cabin.displayCabinInfo());
    }
}
