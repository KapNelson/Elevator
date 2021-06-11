package com.sytoss.edu2021.models;

import com.sytoss.edu2021.models.Cabin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CabinTest {

    Cabin cab = new Cabin(-3, 12);

    @Test
    public void testCabinButtonsSize() {

        assertEquals(cab.getFloorButtons().length, 16);

    }

    @Test
    public void callEmergencyStop() {
        cab.callEmergencyStop();
        assertFalse(cab.getEngine().isEmergencyStop());
    }


}