package com.priyam.parkinglot.model;

/**
 * @author prigupta8
 */
public class ParkingSlot {

    private Integer slotId;
    private Boolean isFree;
    private Car car;

    public ParkingSlot(Integer slotId) {
        this.slotId = slotId;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public Boolean getFree() {
        return isFree;
    }

    public void setFree(Boolean free) {
        isFree = free;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Boolean assignVehice(Car car) {
        this.car = car;
        isFree = Boolean.FALSE;
    }

    public boolean removeVehicle() {
        this.car = car;
        this.isFree = true;
    }
}
