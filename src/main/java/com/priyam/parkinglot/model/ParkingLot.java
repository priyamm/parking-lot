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

    public ParkingLot(Integer size) {
        if(size < 0)
            throw new IllegalArgumentException("Size allotted cannot be negative");
        this.size = size;
        this.slots = new ParkingSlot[this.size];

        for(int i = 1 ; i <= size ; i++) {
            slots[i] = new ParkingSlot(i);
        }

    }

    public String parkVehicle(String registationNumber, String color) {
        for(int i = 1 ; i <= size ; i++) {
            if(slots[i].getFree()) {
                slots[i].assignVehice(new Car(registationNumber, color));
                return String.format("Allocated slot number: %s", i);
            }
        }
        return "Sorry, parking lot is full";
    }

    public String leaveVehice(Integer slotId) {
        if(!slots[slotId].getFree()) {
            slots[slotId].removeVehicle();
            return String.format("Slot number %s is free", slotId);
        }
        return "Already Free";
    }

    public String getStatus() {
        String status = "Slot No. Registration No Colour\n";
        for(int i = 1; i <= size ; i++) {
            if(!slots[i].getFree()) {
                status += i + " " + slots[i].getCar().getRegistrationNumber() + " " + slots[i].getCar().getColor() + "\n";
            }
        }
        return status;
    }

    public String getRegistrationNumbersByCarColor(String color) {
        String registrationNumbers = "";
        for(int i = 1 ; i <= size ; i++) {
            if(!slots[i].getFree()) {
                registrationNumbers += slots[i].getCar().getRegistrationNumber() + ", ";
            }
        }
        return registrationNumbers.charAt(registrationNumbers.length() - 1) == ' ' ? registrationNumbers.substring(0, registrationNumbers.length() - 2) : registrationNumbers;
    }

    public String getSlotNumbersByCarColor(String color) {
        String slotNumbers = "";
        for(int i = 1 ; i <= size ; i++) {
            if(!slots[i].getFree()) {
                slotNumbers += i + ", ";
            }
        }
        return slotNumbers.charAt(slotNumbers.length() - 1) == ' ' ? slotNumbers.substring(0, slotNumbers.length() - 2) : slotNumbers;
    }

    public String getSlotNumberByCarRegistrationNumber(String registrationNumber) {
        for(int i = 1 ; i <= size ; i++) {
            if(!slots[i].getFree() && slots[i].getCar().getRegistrationNumber().equals(registrationNumber))
                return String.valueOf(i);
        }
        return "Not found";
    }

}
