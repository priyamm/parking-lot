package com.priyam.parkinglot;

import com.priyam.parkinglot.model.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author prigupta8
 */
public class ParkingSystemTest {

    private static final Integer SIZE = 6;

    @Test
    public void test_parkingLotSetup() {

        ParkingLot parkingLot  = new ParkingLot(SIZE);
        Assert.assertTrue(parkingLot.getSlots().length == SIZE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_parkingLotInvalidCase() {
        ParkingLot parkingLot  = new ParkingLot(-1);
    }

    @Test
    public void test_parkingVehice() {
        ParkingLot parkingLot  = new ParkingLot(SIZE);
        String whiteCarSlotId = parkingLot.parkCar("KA-01-HH-1234", "White");
        String blueCarSlotId = parkingLot.parkCar("KA-02-HH-1234", "Blue");
        Assert.assertTrue(whiteCarSlotId.equals("Allocated slot number: 1"));
        Assert.assertTrue(blueCarSlotId.equals("Allocated slot number: 2"));
    }

    @Test
    public void test_parkingVehiceWhenFull() {
        ParkingLot parkingLot  = new ParkingLot(1);
        String whiteCarSlotId = parkingLot.parkCar("KA-01-HH-1234", "White");
        String blueCarSlotId = parkingLot.parkCar("KA-02-HH-1234", "Blue");
        Assert.assertTrue(blueCarSlotId.equals("Sorry, parking lot is full"));
    }

    @Test
    public void testLeaveVehice() {
        ParkingLot parkingLot  = new ParkingLot(4);
        parkingLot.parkCar("KA-01-HH-1234", "White");
        parkingLot.parkCar("KA-02-HH-1234", "Blue");
        String unparkBlueCar = parkingLot.leaveCar(2);
        Assert.assertEquals(unparkBlueCar, "Slot number 2 is free");
    }

    @Test
    public void test_getParkingLotStatus() {
        ParkingLot parkingLot  = new ParkingLot(4);
        parkingLot.parkCar("KA-01-HH-1234", "White");
        parkingLot.parkCar("KA-02-HH-1234", "Blue");
    }

    @Test
    public void test_getRegistrationNumbersByCarColor() {
        ParkingLot parkingLot  = new ParkingLot(4);
        parkingLot.parkCar("KA-01-HH-1234", "White");
        parkingLot.parkCar("KA-02-HH-1234", "Blue");
        Assert.assertEquals(parkingLot.getRegistrationNumbersByCarColor("Blue"), "KA-02-HH-1234");
    }

    @Test
    public void test_getRegistrationNumbersByCarColorNotFound() {
        ParkingLot parkingLot  = new ParkingLot(4);
        parkingLot.parkCar("KA-01-HH-1234", "White");
        parkingLot.parkCar("KA-02-HH-1234", "Blue");
        Assert.assertEquals(parkingLot.getRegistrationNumbersByCarColor("Green"), "Not found");
    }

    @Test
    public void test_getSlotNumbersByCarColor() {
        ParkingLot parkingLot  = new ParkingLot(4);
        parkingLot.parkCar("KA-01-HH-1234", "White");
        parkingLot.parkCar("KA-02-HH-1234", "Blue");
        parkingLot.parkCar("KA-03-HH-1234", "White");
        Assert.assertEquals(parkingLot.getSlotNumbersByCarColor("White"), "1, 3");
    }

    @Test
    public void test_getSlotNumbersByCarColorNotFound() {
        ParkingLot parkingLot  = new ParkingLot(4);
        parkingLot.parkCar("KA-01-HH-1234", "White");
        parkingLot.parkCar("KA-02-HH-1234", "Blue");
        parkingLot.parkCar("KA-03-HH-1234", "White");
        Assert.assertEquals(parkingLot.getSlotNumbersByCarColor("Green"), "Not found");
    }


    @Test
    public void test_getSlotNumberByCarRegistrationNumber() {
        ParkingLot parkingLot  = new ParkingLot(4);
        parkingLot.parkCar("KA-01-HH-1234", "White");
        parkingLot.parkCar("KA-02-HH-1234", "Blue");
        parkingLot.parkCar("KA-03-HH-1234", "White");
        Assert.assertEquals(parkingLot.getSlotNumberByCarRegistrationNumber("KA-03-HH-1234"), "3");
    }

    @Test
    public void test_getSlotNumberByCarRegistrationNumberNotFound() {
        ParkingLot parkingLot  = new ParkingLot(4);
        parkingLot.parkCar("KA-01-HH-1234", "White");
        parkingLot.parkCar("KA-02-HH-1234", "Blue");
        parkingLot.parkCar("KA-03-HH-1234", "White");
        Assert.assertEquals(parkingLot.getSlotNumberByCarRegistrationNumber("KA-04-HH-1234"), "Not found");
    }
}
