package com.samratalam.parking_lot_in_spring_boot.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@UserDefinedType("vehicle_udt")
public class VehicleUDT {
    private UUID id;
    private String licensePlate;
    private String color;
    private String size;
    private String vehicleType;
    private Double ratePerHr;
    private Double totalBill;
}
