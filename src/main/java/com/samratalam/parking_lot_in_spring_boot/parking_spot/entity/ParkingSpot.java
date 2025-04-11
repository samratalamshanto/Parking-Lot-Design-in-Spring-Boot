package com.samratalam.parking_lot_in_spring_boot.parking_spot.entity;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.enums.EParkingSpotType;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.Data;

@Data
public abstract class ParkingSpot {
    private final int parkingSpotNumber;
    private final EParkingSpotType parkingSpotType;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int parkingSpotNumber, EParkingSpotType parkingSpot) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.isOccupied = false;
        this.parkingSpotType = parkingSpot;
    }

    public void vacantParkingSpot() {
        if (!this.isOccupied) {
            throw new IllegalArgumentException("Parking Spot is already vacant.");
        }

        this.vehicle = null;
        this.isOccupied = false;
    }

    public int parkVehicle(Vehicle vehicle) {
        if (this.isOccupied) {
            throw new IllegalArgumentException("Parking Spot is occupied. Cannot park here.");
        }

        if (!this.canParkVehicle(vehicle)) {  //vehicle can park this spot??
            throw new IllegalArgumentException("This Vehicle cannot park this spot.");
        }

        this.vehicle = vehicle;
        this.isOccupied = true;
        return this.parkingSpotNumber;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);
}
