package com.samratalam.parking_lot_in_spring_boot.parking_spot.entity;

import com.samratalam.parking_lot_in_spring_boot.utility.AppUtil;
import com.samratalam.parking_lot_in_spring_boot.vehicle.dto.VehicleUDT;
import com.samratalam.parking_lot_in_spring_boot.vehicle.entity.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("parking_spot")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class ParkingSpotEntity extends ParkingSpot {

    public ParkingSpotEntity(UUID id, int parkingSpotNumber, String parkingSpotType, boolean isOccupied, VehicleUDT vehicleUdt, int parkingFloor) {
        super(id, parkingSpotNumber, parkingSpotType, isOccupied, vehicleUdt, parkingFloor, AppUtil.getCurrentDateTime(), null);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return true;
    }
}
