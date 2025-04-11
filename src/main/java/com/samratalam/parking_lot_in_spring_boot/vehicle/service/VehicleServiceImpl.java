package com.samratalam.parking_lot_in_spring_boot.vehicle.service;

import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;

public class VehicleServiceImpl implements VehicleService {


    public Double calculateParkingFee(Vehicle vehicle, int totalHrs) {
        return vehicle.getRatePerHr() * totalHrs;
    }
}
