package com.samratalam.parking_lot_in_spring_boot.vehicle.entity;

import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleColor;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public abstract class Vehicle {
    private final String licensePlate;
    private final EVehicleColor color;
    private final EVehicleSize size;

    public abstract Double calculateParkingFee(int totalHrs);
    public Vehicle(String licensePlate, EVehicleColor color, EVehicleSize size) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.size = size;
    }
}
