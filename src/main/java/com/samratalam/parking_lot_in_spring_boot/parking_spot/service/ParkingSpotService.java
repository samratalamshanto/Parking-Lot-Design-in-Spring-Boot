package com.samratalam.parking_lot_in_spring_boot.parking_spot.service;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;

public interface ParkingSpotService {
    void vacantParkingSpot(ParkingSpot parkingSpot);

    int parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot);

    void saveParkingSpot(ParkingSpot parkingSpot);

    ParkingSpot findAvailableSpot(String parkingSpotName);

    ParkingSpot parkVehicle(Vehicle vehicle);

    void vacantParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle);

    ParkingSpot findParkingSpotByVehiclePlateNumber(String vehiclePlateNumber);
}
