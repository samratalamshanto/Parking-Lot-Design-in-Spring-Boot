package com.samratalam.parking_lot_in_spring_boot.vehicle.entity;

import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleColor;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleSize;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleType;

public class Bike extends Vehicle {
    private final Double RATE = 5.0;

    public Bike(String licensePlate, EVehicleColor vehicleColor) {
        super(licensePlate, vehicleColor, EVehicleSize.S, EVehicleType.BIKE);
    }

    @Override
    public Double calculateParkingFee(int totalHrs) {
        return RATE * totalHrs;
    }
}
