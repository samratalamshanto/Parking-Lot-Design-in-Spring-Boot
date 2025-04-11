package com.samratalam.parking_lot_in_spring_boot.vehicle.entity;

import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleColor;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleSize;

public class Car extends Vehicle {
    private final Double RATE = 10.0;

    public Car(String licensePlate, EVehicleColor vehicleColor) {
        super(licensePlate, vehicleColor, EVehicleSize.M);
    }


    @Override
    public Double calculateParkingFee(int totalHrs) {
        return RATE * totalHrs;
    }
}
