package com.samratalam.parking_lot_in_spring_boot.vehicle.entity;

import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleColor;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleSize;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleType;
import lombok.Getter;

@Getter
public abstract class Vehicle {
    private final String licensePlate;
    private final EVehicleColor color;
    private final EVehicleSize size;
    private final EVehicleType vehicleType;

    public Vehicle(String licensePlate, EVehicleColor color, EVehicleSize size, EVehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.size = size;
        this.vehicleType = vehicleType;
    }

    public abstract Double calculateParkingFee(int totalHrs);
}
