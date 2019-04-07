package com.priyam.parkinglot.model;

/**
 * @author prigupta8
 */
public class ParkingLot {
    private Integer size;
    private ParkingSlot[] slots;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ParkingSlot[] getSlots() {
        return slots;
    }

    public void setSlots(ParkingSlot[] slots) {
        this.slots = slots;
    }

    /**
     * @param size
     */
    public ParkingLot(Integer size) {
        if(size < 0)
            throw new IllegalArgumentException("Size allotted cannot be negative");
        this.size = size;
        this.slots = new ParkingSlot[this.size];

        for(int i = 0 ; i < size ; i++) {
            slots[i] = new ParkingSlot(i);
        }

    }

    /**
     * @param registationNumber
     * @param color
     * @return String
     * This method is used to park Car into the Parking Lot. If there is space present
     * in the parking lot, the car is parked else it return appropriate message.
     */
    public String parkCar(String registationNumber, String color) {
        for(int i = 0 ; i < size ; i++) {
            if(slots[i].getFree()) {
                slots[i].assignVehice(new Car(registationNumber, color));
                return String.format("Allocated slot number: %s", i + 1);
            }
        }
        return "Sorry, parking lot is full";
    }

    public String leaveCar(Integer slotId) {
        if(!slots[slotId - 1].getFree()) {
            slots[slotId - 1].removeVehicle();
            return String.format("Slot number %s is free", slotId);
        }
        return "Already Free";
    }

    public String getParkingLotStatus() {
        String status = "Slot No. Registration No Colour\n";
        for(int i = 0; i < size ; i++) {
            if(!slots[i - 1].getFree()) {
                status += (i + 1) + " " + slots[i].getCar().getRegistrationNumber() + " " + slots[i].getCar().getColor() + "\n";
            }
        }
        return status;
    }

    public String getRegistrationNumbersByCarColor(String color) {
        String registrationNumbers = "";
        for(int i = 0 ; i < size ; i++) {
            if(!slots[i].getFree() && slots[i].getCar().getColor().equals(color)) {
                registrationNumbers += slots[i].getCar().getRegistrationNumber() + ", ";
            }
        }
        if(registrationNumbers.isEmpty())
            return "Not found";
        return registrationNumbers.charAt(registrationNumbers.length() - 1) == ' ' ? registrationNumbers.substring(0, registrationNumbers.length() - 2) : registrationNumbers;
    }

    public String getSlotNumbersByCarColor(String color) {
        String slotNumbers = "";
        for(int i = 0 ; i < size ; i++) {
            if(!slots[i].getFree() && slots[i].getCar().getColor().equals(color)) {
                slotNumbers += (i + 1) + ", ";
            }
        }
        if(slotNumbers.isEmpty())
            return "Not found";
        return slotNumbers.charAt(slotNumbers.length() - 1) == ' ' ? slotNumbers.substring(0, slotNumbers.length() - 2) : slotNumbers;
    }

    public String getSlotNumberByCarRegistrationNumber(String registrationNumber) {
        for(int i = 0 ; i < size ; i++) {
            if(!slots[i].getFree() && slots[i].getCar().getRegistrationNumber().equals(registrationNumber))
                return String.valueOf(i + 1);
        }
        return "Not found";
    }

}
