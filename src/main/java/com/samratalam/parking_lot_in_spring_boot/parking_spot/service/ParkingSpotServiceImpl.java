package com.samratalam.parking_lot_in_spring_boot.parking_spot.service;

import com.samratalam.parking_lot_in_spring_boot.mapper.VehicleMapper;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpotEntity;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.repository.ParkingSpotRepo;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingSpotServiceImpl implements ParkingSpotService {
    private final ParkingSpotRepo parkingSpotRepo;
    private final HashMap<String, ParkingSpot> parkingSpotMap = new HashMap<>();

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
        parkingSpot.setOccupied(true);
        return parkingSpot.getParkingSpotNumber();
    }

    @Override
    public void saveParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotRepo.updateParkingSpot(parkingSpot.getId());
    }

    @Override
    public ParkingSpot findAvailableSpot(String parkingSpotName) {
        List<ParkingSpotEntity> parkingSpotList = parkingSpotRepo.findAllAvailableSpots(parkingSpotName);
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (!parkingSpot.isOccupied()) {
                return parkingSpot;
            }
        }
        return null;
    }


    @Override
    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = null;
        parkingSpot = findAvailableSpot(vehicle.getVehicleType());
        if (parkingSpot != null) {
            parkVehicle(vehicle, parkingSpot);
            parkingSpotMap.put(vehicle.getLicensePlate(), parkingSpot);
            return parkingSpot;
        } else {
            throw new IllegalArgumentException("Parking Spot not available right now.");
        }
    }

    @Override
    public void vacantParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle) {
        if (parkingSpot != null && parkingSpot.getVehicleUdt().getId().equals(vehicle.getId())) {
            vacantParkingSpot(parkingSpot);
            parkingSpotMap.remove(vehicle.getLicensePlate());
        } else {
            throw new IllegalArgumentException("Invalid operation. Parking Spot or Vehicle is not correct.");
        }
    }

    @Override
    public ParkingSpot findParkingSpotByVehiclePlateNumber(String vehiclePlateNumber) {
        if (parkingSpotMap.containsKey(vehiclePlateNumber)) {
            return parkingSpotMap.get(vehiclePlateNumber);
        } else {
            throw new IllegalArgumentException("Parking spot not found by this Plate Number + " + vehiclePlateNumber);
        }
    }
}
