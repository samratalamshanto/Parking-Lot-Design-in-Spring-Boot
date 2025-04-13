package com.samratalam.parking_lot_in_spring_boot.parking_spot.entity;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.enums.EParkingSpotType;
import com.samratalam.parking_lot_in_spring_boot.utility.AppUtil;
import com.samratalam.parking_lot_in_spring_boot.vehicle.dto.VehicleUDT;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ParkingSpot {
    @PrimaryKey
    private UUID id;
    private int parkingSpotNumber;
    private String parkingSpotType;
    private boolean isOccupied;
    private VehicleUDT vehicleUdt;
    private int parkingFloor;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    ParkingSpot(int parkingSpotNumber, EParkingSpotType parkingSpot) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.isOccupied = false;
        this.parkingSpotType = parkingSpot.name();
        this.createdTime = AppUtil.getCurrentDateTime();
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);
}
