package com.priyam.parkinglot;

import com.priyam.parkinglot.model.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

public class ParkingSystemTest {

    private static final Integer SIZE = 6;

    @Test
    public void parkingLotSizeTest() {

        ParkingLot parkingLot  = new ParkingLot(SIZE);
        Assert.assertTrue(parkingLot.getSlots().length == SIZE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeSizeTest() {
        ParkingLot parkingLot  = new ParkingLot(-1);
    }

    public void testParkingVehice() {
        ParkingLot parkingLot  = new ParkingLot(SIZE);
        Integer whiteCarSlotId = parkingLot.parkVehicle("KA-01-HH-1234", "White");
        Integer blueCarSlotId = parkingLot.parkVehicle("KA-01-HH-1234", "Blue");
        Assert.assert(whiteCarSlotId.equals(1));
        Assert.assert(blueCarSlotId.equals(1));
    }
}
