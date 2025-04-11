package com.samratalam.parking_lot_in_spring_boot.parking_spot.entity;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.enums.EParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int parkingSpotNumber) {
        super(parkingSpotNumber, EParkingSpot.CAR);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return false;
    }
}
