package com.samratalam.parking_lot_in_spring_boot.vehicle.service;

import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;

public interface VehicleService {
    Double calculateParkingFee(Vehicle vehicle, int totalHrs);
}
