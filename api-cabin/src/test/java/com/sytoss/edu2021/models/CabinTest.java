package com.sytoss.edu2021.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CabinTest {

    @Test
    public void oneFloors()
    {
        Cabin cabin = new Cabin(0,0);
        assertEquals(cabin.getFloorButtons().length,1);

    }

    @Test
    public void minusFloors()
    {
        Cabin cabin = new Cabin(-5,5);
        assertEquals(cabin.getFloorButtons().length,11);

    }

}