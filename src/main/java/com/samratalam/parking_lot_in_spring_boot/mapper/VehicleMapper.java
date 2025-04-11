package com.samratalam.parking_lot_in_spring_boot.mapper;

import com.samratalam.parking_lot_in_spring_boot.vehicle.dto.VehicleUDT;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import org.modelmapper.ModelMapper;

public final class VehicleMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static VehicleUDT mapToVehicleUDT(Vehicle vehicle) {
        VehicleUDT vehicleUDT = new VehicleUDT();
        modelMapper.map(vehicle, vehicleUDT);
        return vehicleUDT;
    }
}
