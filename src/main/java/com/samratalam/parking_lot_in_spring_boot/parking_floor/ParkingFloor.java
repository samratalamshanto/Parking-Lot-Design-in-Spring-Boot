package com.samratalam.parking_lot_in_spring_boot.parking_floor;

import com.samratalam.parking_lot_in_spring_boot.mapper.VehicleMapper;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.entity.ParkingSpot;
import com.samratalam.parking_lot_in_spring_boot.parking_spot.service.ParkingSpotService;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ParkingFloor {
    @Autowired
    private ParkingSpotService parkingSpotService;
    private List<ParkingSpot> parkingSpotList;
    private HashMap<String, ParkingSpot> parkingSpotMap;
    private int floorNumber;

    public ParkingSpot findAvailableSpot(String parkingSpotName) {
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (!parkingSpot.isOccupied() && parkingSpotName.equalsIgnoreCase(parkingSpot.getParkingSpotType())) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = null;
        parkingSpot = findAvailableSpot(vehicle.getVehicleType());
        if (parkingSpot != null) {
            parkingSpotService.parkVehicle(vehicle, parkingSpot);
            parkingSpotMap.put(vehicle.getLicensePlate(), parkingSpot);
            return parkingSpot;
        } else {
            throw new IllegalArgumentException("Parking Spot not available right now.");
        }
    }

    public void vacantParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle) {
        if (parkingSpot != null && parkingSpot.getVehicleUdt().equals(VehicleMapper.mapToVehicleUDT(vehicle))) {
            parkingSpotService.vacantParkingSpot(parkingSpot);
            parkingSpotMap.remove(vehicle.getLicensePlate());
        } else {
            throw new IllegalArgumentException("Invalid operation. Parking Spot or Vehicle is not correct.");
        }
    }

    public ParkingSpot findParkingSpotByVehiclePlateNumber(String vehiclePlateNumber) {
        if (parkingSpotMap.containsKey(vehiclePlateNumber)) {
            return parkingSpotMap.get(vehiclePlateNumber);
        } else {
            throw new IllegalArgumentException("Parking spot not found by this Plate Number + " + vehiclePlateNumber);
        }
    }
}
