package com.samratalam.parking_lot_in_spring_boot.parking_spot.service;

import com.samratalam.parking_lot_in_spring_boot.mapper.VehicleMapper;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingSpotServiceImpl implements ParkingSpotService {

    @Override
    public void vacantParkingSpot(ParkingSpot parkingSpot) {
        if (!parkingSpot.isOccupied()) {
            throw new IllegalArgumentException("Parking Spot is already vacant.");
        }

        parkingSpot.setVehicleUdt(null);
        parkingSpot.setOccupied(false);
    }

    @Override
    public int parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot) {
        if (parkingSpot.isOccupied()) {
            throw new IllegalArgumentException("Parking Spot is occupied. Cannot park here.");
        }

        if (!parkingSpot.canParkVehicle(vehicle)) {  // vehicle can park this spot??
            throw new IllegalArgumentException("This Vehicle cannot park this spot.");
        }

        parkingSpot.setVehicleUdt(VehicleMapper.mapToVehicleUDT(vehicle));
        parkingSpot.setOccupied(false);
        return parkingSpot.getParkingSpotNumber();
    }
}
