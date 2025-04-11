package com.samratalam.parking_lot_in_spring_boot.parking_spot.entity;

import com.samratalam.parking_lot_in_spring_boot.parking_spot.enums.EParkingSpotType;
import com.samratalam.parking_lot_in_spring_boot.vehicle.dto.VehicleUDT;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("parking_spot")
public abstract class ParkingSpot {
    @PrimaryKey
    private UUID id;
    private int parkingSpotNumber;
    private String parkingSpotType;
    private boolean isOccupied;
    private VehicleUDT vehicleUdt;

    public ParkingSpot(int parkingSpotNumber, EParkingSpotType parkingSpot) {
        this.parkingSpotNumber = parkingSpotNumber;
        this.isOccupied = false;
        this.parkingSpotType = parkingSpot.name();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(String parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public VehicleUDT getVehicleUdt() {
        return vehicleUdt;
    }

    public void setVehicleUdt(VehicleUDT vehicleUdt) {
        this.vehicleUdt = vehicleUdt;
    }

    public abstract boolean canParkVehicle(Vehicle vehicle);
}
