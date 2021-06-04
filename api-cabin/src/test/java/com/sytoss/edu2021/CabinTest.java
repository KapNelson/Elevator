package com.sytoss.edu2021;


import com.sytoss.edu2021.models.Cabin;
import com.sytoss.edu2021.models.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CabinTest {

    Cabin cab = new Cabin(-3, 12);

    @Test
    public void testCabinButtonsSize() {

        assertEquals(cab.getFloorButtons().length, 16);

    }

    @Test
    public void directionTestsUP() {

        cab.addFloorToStop(12);
        assertEquals(Direction.UP, cab.getDirection());

    }

    @Test
    public void directionTestsDOWN() {

        cab.setCurrentFloor(12);
        cab.addFloorToStop(-3);
        assertEquals(cab.getDirection(), Direction.DOWN);

    }

    @Test
    public void directionTestsTheSame() {

        cab.addFloorToStop(-3);
        assertEquals(cab.getDirection(), Direction.STABLE);

    }


}