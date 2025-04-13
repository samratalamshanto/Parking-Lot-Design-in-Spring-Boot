package com.samratalam.parking_lot_in_spring_boot.vehicle.service;

import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.VehicleEntity;
import com.samratalam.parking_lot_in_spring_boot.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    ModelMapper modelMapper = new ModelMapper();

    public Double calculateParkingFee(Vehicle vehicle, int totalHrs) {
        return vehicle.getRatePerHr() * totalHrs;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        modelMapper.map(vehicle, vehicleEntity);
        vehicleRepository.save(vehicleEntity);
    }
}
