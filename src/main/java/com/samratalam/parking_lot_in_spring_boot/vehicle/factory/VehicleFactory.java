package com.samratalam.parking_lot_in_spring_boot.vehicle.factory;

import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Bike;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Car;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Truck;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleColor;
import com.samratalam.parking_lot_in_spring_boot.vehicle.enums.EVehicleType;

public class VehicleFactory {

    public static Vehicle createVehicle(String vehicleType, String licensePlate, EVehicleColor vehicleColor) {
        EVehicleType eVehicleType = EVehicleType.valueOf(vehicleType);

        switch (eVehicleType) {
            case CAR -> new Car(licensePlate, vehicleColor);
            case BIKE -> new Bike(licensePlate, vehicleColor);
            case TRUCK -> new Truck(licensePlate, vehicleColor);
            default -> throw new IllegalArgumentException("Invalid vehicle type: " + vehicleType);
        }
        return null;  //
    }
}
