package com.samratalam.parking_lot_in_spring_boot.parking_spot;

import com.samratalam.parking_lot_in_spring_boot.vehicle.dto.VehicleUDT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@UserDefinedType("parking_spot_udt")
public class ParkingSpotUDT {
    private UUID id;
    private int parkingSpotNumber;
//    private int parkingFloor;
    private String parkingSpotType;
    private boolean isOccupied;
    private VehicleUDT vehicleUdt;
}
