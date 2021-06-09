package com.sytoss.edu2021;

import com.sytoss.edu2021.models.Cabin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CabinTest {

    Cabin cab = new Cabin(-3, 12);

    @Test
    public void testCabinButtonsSize() {

        assertEquals(cab.getFloorButtons().length, 16);

    }


}