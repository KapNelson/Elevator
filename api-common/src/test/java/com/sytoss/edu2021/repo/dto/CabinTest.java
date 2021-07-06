package com.sytoss.edu2021.repo.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CabinTest {

    private final CabinBOM cab = new CabinBOM(-3, 12);

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