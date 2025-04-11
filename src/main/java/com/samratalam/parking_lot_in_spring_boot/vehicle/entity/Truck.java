package com.samratalam.parking_lot_in_spring_boot.vehicle.entity;

import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleColor;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleSize;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleType;

public class Truck extends Vehicle {
    private final Double RATE = 50.0;

    public Truck(String licensePlate, EVehicleColor vehicleColor) {
        super(licensePlate, vehicleColor, EVehicleSize.L, EVehicleType.TRUCK);
    }

    @Override
    public Double calculateParkingFee(int totalHrs) {
        return RATE * totalHrs;
    }
}
