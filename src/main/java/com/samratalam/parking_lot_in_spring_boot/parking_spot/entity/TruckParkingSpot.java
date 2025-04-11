package com.samratalam.parking_lot_in_spring_boot.parking_spot.entity;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.enums.EParkingSpotType;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;

public class TruckParkingSpot extends ParkingSpot {
    public TruckParkingSpot(int parkingSpotNumber) {
        super(parkingSpotNumber, EParkingSpotType.TRUCK);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return false;
    }
}
